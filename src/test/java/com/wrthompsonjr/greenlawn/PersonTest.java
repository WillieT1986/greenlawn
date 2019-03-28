package com.wrthompsonjr.greenlawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PersonTest {

	@Test
	public void shouldInstantiateAPerson() {
		Person underTest = new Person("", "", "", "", "", null, "");
		assertNotNull(underTest);
	}

	@Test
	public void shouldConstructAndReturnPersonName() {
		Person underTest = new Person("name", "", "", "", "", null, "");
		String check = underTest.getName();
		assertEquals("name", check);
	}

	@Test
	public void shouldReturnPersonDateOfBirth() {
		Person underTest = new Person("", "DOB", "", "", "", null, "");
		String check = underTest.getDateOfBirth();
		assertEquals("DOB", check);
	}

	@Test
	public void shouldReturnPersonDateOfDeath() {
		Person underTest = new Person("", "", "DOD", "", "", null, "");
		String check = underTest.getDateOfDeath();
		assertEquals("DOD", check);
	}

	@Test
	public void shouldReturnPersonStatus() {
		Person underTest = new Person("", "", "", "status", "", null, "");
		String check = underTest.getStatus();
		assertEquals("status", check);
	}

	@Test
	public void shouldReturnPersonDescription() {
		Person underTest = new Person("", "", "", "", "Description", null, "");
		String check = underTest.getDrescription();
		assertEquals("Description", check);
	}

	@Test
	public void shouldAddReligionToPerson() {
		Person underTest = new Person("", "", "", "", "", null, "Religion");
		String check = underTest.getReligion();
		assertEquals("Religion", check);
	}
}