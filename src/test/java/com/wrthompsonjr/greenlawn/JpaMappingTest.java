package com.wrthompsonjr.greenlawn;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingTest {

	private static final String TOMBSTONE_IMAGE_URL = "Tombstone Image";
	private static final String NAME_OF_PERSON = "name";
	private static final String US_STATE = "State";
	private static final String MILITARY_RANK = "Rank";
	private static final String MILITARY_BRANCH = "Branch";
	private static final String MILITARY_UNIT = "Unit";
	private static final String DATE_OF_BIRTH = "DOB";
	private static final String DATE_OF_DEATH = "DOD";
	private static final String STATUS = "Status";
	private static final String OBITUARY = "Description";
	private static final CemeterySection CEMETERY_SECTION = null;
	private static final String RELIGION = "Religion";

	GraveSite underTest;

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private GraveSiteRepository graveSiteRepo;

	@Resource
	private CemeterySectionRepository cemeterySectionRepo;

	@Resource
	private TagRepository tagRepo;

	@Before
	public void shouldSetUp() {
		underTest = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
				MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION, RELIGION);
	}

	@Test
	public void shouldSaveAndLoadGraveSite() {
		underTest = graveSiteRepo.save(underTest);
		Long personId = underTest.getId();

		entityManager.flush();
		entityManager.clear();

		underTest = graveSiteRepo.getOne(personId);
		assertThat(underTest.getName(), is(NAME_OF_PERSON));
	}

	@Test
	public void shouldSaveGraveSiteToSectionRelationship() {
		CemeterySection section = new CemeterySection("101");
		cemeterySectionRepo.save(section);
		long sectionId = section.getId();

		GraveSite firstGraveSite = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK,
				MILITARY_BRANCH, MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, section, RELIGION);
		firstGraveSite = graveSiteRepo.save(firstGraveSite);

		GraveSite secondGraveSite = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK,
				MILITARY_BRANCH, MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, section, RELIGION);
		secondGraveSite = graveSiteRepo.save(secondGraveSite);

		entityManager.flush();
		entityManager.clear();

		section = cemeterySectionRepo.getOne(sectionId);
		assertThat(section.getGraveSites(), containsInAnyOrder(firstGraveSite, secondGraveSite));
	}

	@Test
	public void shouldSaveAndLoadTag() {
		Tag tag = tagRepo.save(new Tag("tagName"));
		long tagId = tag.getId();

		entityManager.flush();
		entityManager.clear();

		tag = tagRepo.getOne(tagId);
		assertThat(tag.getTag(), is("tagName"));
	}

	@Test
	public void shouldEstablishGraveSiteToTagRelationship() {
		Tag veteran = tagRepo.save(new Tag("Veteran"));
		Tag electedOfficial = tagRepo.save(new Tag("Elected Official"));

		GraveSite graveSite = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK,
				MILITARY_BRANCH, MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION,
				RELIGION, veteran, electedOfficial);
		graveSite = graveSiteRepo.save(graveSite);
		long personName = graveSite.getId();

		graveSite = graveSiteRepo.getOne(personName);
		assertThat(graveSite.getTags(), containsInAnyOrder(veteran, electedOfficial));
	}

	@Test
	public void shouldEstablishTagToGraveSiteRelationship() {
		Tag tag = tagRepo.save(new Tag("Veteran"));
		long tagId = tag.getId();

		GraveSite firstPerson = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK,
				MILITARY_BRANCH, MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION,
				RELIGION, tag);
		firstPerson = graveSiteRepo.save(firstPerson);

		GraveSite secondPerson = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK,
				MILITARY_BRANCH, MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION,
				RELIGION, tag);
		secondPerson = graveSiteRepo.save(secondPerson);

		entityManager.flush();
		entityManager.clear();

		tag = tagRepo.getOne(tagId);
		assertThat(tag.getPersons(), containsInAnyOrder(firstPerson, secondPerson));
	}

	@Test
	public void shouldReturnTheNameDateOfBirthDateOfDeathStatusAndDescriptionOfAGraveSite() {
		Tag tag = tagRepo.save(new Tag("Veteran"));

		GraveSite underTest = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK,
				MILITARY_BRANCH, MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION,
				RELIGION, tag);
		String check = underTest.getName();
		String check2 = underTest.getDateOfBirth();
		String check3 = underTest.getDateOfDeath();
		String check4 = underTest.getStatus();
		String check5 = underTest.getObituary();

		assertEquals(check, NAME_OF_PERSON);
		assertEquals(check2, DATE_OF_BIRTH);
		assertEquals(check3, DATE_OF_DEATH);
		assertEquals(check4, STATUS);
		assertEquals(check5, OBITUARY);
	}
}