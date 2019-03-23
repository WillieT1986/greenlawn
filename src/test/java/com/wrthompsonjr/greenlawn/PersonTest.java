package com.wrthompsonjr.greenlawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PersonTest {

	@Test
	public void shouldInstantiateAPerson() {
		Person underTest = new Person("", "", "", "", "", 0);
		assertNotNull(underTest);
	}

	@Test
	public void shouldConstructAndReturnPersonName() {
		Person underTest = new Person("name", "", "", "", "", 0);
		String check = underTest.getName();
		assertEquals("name", check);
	}

	@Test
	public void shouldReturnPersonDateOfBirth() {
		Person underTest = new Person("", "DOB", "", "", "", 0);
		String check = underTest.getDateOfBirth();
		assertEquals("DOB", check);
	}

	@Test
	public void shouldReturnPersonDateOfDeath() {
		Person underTest = new Person("", "", "DOD", "", "", 0);
		String check = underTest.getDateOfDeath();
		assertEquals("DOD", check);
	}

	@Test
	public void shouldReturnPersonStatus() {
		Person underTest = new Person("", "", "", "status", "", 0);
		String check = underTest.getStatus();
		assertEquals("status", check);
	}

	@Test
	public void shouldReturnPersonDescription() {
		Person underTest = new Person("", "", "", "", "Description", 0);
		String check = underTest.getDrescription();
		assertEquals("Description", check);
	}

	@Test
	public void shouldReturnCemeterySection() {
		Person underTest = new Person("", "", "", "", "", 101);
		int check = underTest.getCemeterySection();
		assertEquals(101, check);
	}
}