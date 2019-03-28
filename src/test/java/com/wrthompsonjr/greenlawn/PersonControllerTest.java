package com.wrthompsonjr.greenlawn;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wrthompsonjr.greenlawn.PersonRestController.CannotFindException;

public class PersonControllerTest {

	@InjectMocks
	private PersonRestController underTest;

	@Mock
	private Person person;

	@Mock
	private CemeterySection cemeterySection;

	@Mock
	private Tag tag;

	@Mock
	private PersonRepository personRepo;

	@Mock
	private CemeterySectionRepository sectionRepo;

	@Mock
	private TagRepository tagRepo;

	@Mock
	private Collection<Person> persons;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldRetrievePersons() {
		when(personRepo.findAll()).thenReturn(Collections.singletonList(person));
		Iterable<Person> result = underTest.findPersons();
		assertThat(result, contains(any(Person.class)));
	}

	@Test
	public void shouldGetPersonsFromDatabase() {
		when(personRepo.findAll()).thenReturn(Collections.singletonList(person));
		Iterable<Person> result = underTest.findPersons();
		assertThat(result, contains(person));
	}

	@Test
	public void shouldReturnIndividualPersonFromDatabase() {
		when(personRepo.getOne(130000L)).thenReturn(person);
		Person result = underTest.findPerson(130000L);
		assertThat(result, is(person));
	}

	@Test(expected = CannotFindException.class)
	public void shouldReturnCannotFindExceptionForPersonId() {
		long invalidPersonId = 36L;
		underTest.findPerson(invalidPersonId);
	}

	@Test
	public void shouldReturnAListOfCemeterySections() {
		when(sectionRepo.findAll()).thenReturn(Collections.singletonList(cemeterySection));
		Iterable<CemeterySection> result = underTest.findCemeterySections();
		assertThat(result, contains(any(CemeterySection.class)));
	}

	@Test
	public void shouldReturnAnIndividualCemeterySectionFromDatabase() {
		when(sectionRepo.getOne(88L)).thenReturn(cemeterySection);
		CemeterySection result = underTest.findCemeterySection(88L);
		assertThat(result, is(cemeterySection));
	}

	@Test
	public void shouldReturnAListOfTags() {
		when(tagRepo.findAll()).thenReturn(Collections.singletonList(tag));
		Iterable<Tag> result = underTest.findTags();
		assertThat(result, contains(any(Tag.class)));
	}

}