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

import com.wrthompsonjr.greenlawn.data.CemeterySectionRepository;
import com.wrthompsonjr.greenlawn.data.GraveSiteRepository;
import com.wrthompsonjr.greenlawn.data.TagRepository;
import com.wrthompsonjr.greenlawn.models.CemeterySection;
import com.wrthompsonjr.greenlawn.models.GraveSite;
import com.wrthompsonjr.greenlawn.models.Tag;

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

	GraveSite graveSite;
	Tag veteran;
	Tag electedOfficial;

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
		graveSite = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
				MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION, RELIGION);

		veteran = tagRepo.save(new Tag("Veteran"));
		electedOfficial = tagRepo.save(new Tag("Elected Official"));
	}

	@Test
	public void shouldSaveAndLoadGraveSite() {
		graveSite = graveSiteRepo.save(graveSite);
		long graveSiteId = graveSite.getId();

		entityManager.flush();
		entityManager.clear();

		graveSite = graveSiteRepo.getOne(graveSiteId);
		assertThat(graveSite.getName(), is(NAME_OF_PERSON));
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
		long tagId = veteran.getId();

		entityManager.flush();
		entityManager.clear();

		veteran = tagRepo.getOne(tagId);
		assertThat(veteran.getTag(), is("Veteran"));
	}

	@Test
	public void shouldEstablishGraveSiteToTagRelationship() {
		graveSite = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
				MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION, RELIGION, veteran,
				electedOfficial);

		graveSite = graveSiteRepo.save(graveSite);
		long graveSiteId = graveSite.getId();

		graveSite = graveSiteRepo.getOne(graveSiteId);
		assertThat(graveSite.getTags(), containsInAnyOrder(veteran, electedOfficial));
	}

	@Test
	public void shouldEstablishTagToGraveSiteRelationship() {
		long tagId = veteran.getId();

		GraveSite firstGraveSite = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK,
				MILITARY_BRANCH, MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION,
				RELIGION, veteran);
		firstGraveSite = graveSiteRepo.save(firstGraveSite);

		GraveSite secondGraveSite = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK,
				MILITARY_BRANCH, MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION,
				RELIGION, veteran);
		secondGraveSite = graveSiteRepo.save(secondGraveSite);

		entityManager.flush();
		entityManager.clear();

		veteran = tagRepo.getOne(tagId);
		assertThat(veteran.getGraveSites(), containsInAnyOrder(firstGraveSite, secondGraveSite));
	}

	@Test
	public void shouldReturnTheNameDateOfBirthDateOfDeathStatusAndDescriptionOfAGraveSite() {
		String check = graveSite.getName();
		String check2 = graveSite.getDateOfBirth();
		String check3 = graveSite.getDateOfDeath();
		String check4 = graveSite.getStatus();
		String check5 = graveSite.getObituary();

		assertEquals(check, NAME_OF_PERSON);
		assertEquals(check2, DATE_OF_BIRTH);
		assertEquals(check3, DATE_OF_DEATH);
		assertEquals(check4, STATUS);
		assertEquals(check5, OBITUARY);
	}
}