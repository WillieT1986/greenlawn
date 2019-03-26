package com.wrthompsonjr.greenlawn;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private PersonRepository personRepo;

	@Resource
	private CemeterySectionRepository sectionRepo;

	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadPerson() {
		Person person = new Person("personName", "DateOfBirth", "DateOfDeath", "Status", "Description", null);
		person = personRepo.save(person);
		Long personId = person.getId();

		entityManager.flush();
		entityManager.clear();

		person = personRepo.getOne(personId);
		assertThat(person.getName(), is("personName"));
	}

	@Test
	public void shouldSavePersonToSectionRelationship() {
		CemeterySection section = new CemeterySection(101);
		sectionRepo.save(section);
		long sectionId = section.getId();

		Person firstPerson = new Person("personName", "DateOfBirth", "DateOfDeath", "Status", "Description", section);
		firstPerson = personRepo.save(firstPerson);

		Person secondPerson = new Person("personName", "DateOfBirth", "DateOfDeath", "Status", "Description", section);
		secondPerson = personRepo.save(secondPerson);

		entityManager.flush();
		entityManager.clear();

		section = sectionRepo.getOne(sectionId);
		assertThat(section.getPersons(), containsInAnyOrder(firstPerson, secondPerson));
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
	public void shouldEstablishPersonToTagRelationship() {
		Tag veteran = tagRepo.save(new Tag("Veteran"));
		Tag electedOfficial = tagRepo.save(new Tag("Elected Official"));

		Person person = new Person("personName", "DateOfBirth", "DateOfDeath", "Status", "Description", null, veteran,
				electedOfficial);
		person = personRepo.save(person);
		long personName = person.getId();

		person = personRepo.getOne(personName);
		assertThat(person.getTags(), containsInAnyOrder(veteran, electedOfficial));
	}

}