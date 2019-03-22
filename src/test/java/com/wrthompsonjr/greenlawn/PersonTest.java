package com.wrthompsonjr.greenlawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PersonTest {

	@Test
	public void shouldInstantiateAPerson() {
		Person underTest = new Person("");
		assertNotNull(underTest);
	}

	@Test
	public void shouldConstructAndReturnPersonName() {
		Person underTest = new Person("Name");
		String check = underTest.getName();
		assertEquals("name", check);
	}

}
