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

public class PersonControllerTest {

	@InjectMocks
	private PersonRestController underTest;

	@Mock
	private Person person;

	@Mock
	private PersonRepository personRepo;

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
	public void shouldReturnIndividualPersonFromDatabase() throws Exception {
		when(personRepo.getOne(88L)).thenReturn(person);
		Person result = underTest.findPerson(88L);
		assertThat(result, is(88L));
	}

}
