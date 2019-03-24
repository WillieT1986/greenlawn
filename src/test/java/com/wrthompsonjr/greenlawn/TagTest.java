package com.wrthompsonjr.greenlawn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TagTest {

	@Test
	public void shouldConstructAndReturnTagName() {
		Tag underTest = new Tag("Name");
		String check = underTest.getTag();
		assertEquals("Name", check);
	}
}
