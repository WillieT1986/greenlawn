package com.wrthompsonjr.greenlawn;

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

	@Test
	public void shouldSaveAndLoadPerson() {
		Person person = new Person("personName", "DateOfBirth", "DateOfDeath", "Status", "Description");
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
	}

}
