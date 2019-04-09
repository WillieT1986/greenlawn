package com.wrthompsonjr.greenlawn.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.wrthompsonjr.greenlawn.models.CemeterySection;

public class CemeterySectionTest {

	private static final String CEMETERY_SECTION = "101";

	CemeterySection underTest;

	@Before
	public void setUp() {
		underTest = new CemeterySection(CEMETERY_SECTION);
	}

	@Test
	public void shouldInstantiateCemeterySection() {
		assertNotNull(underTest);
	}

	@Test
	public void shouldConstructAndReturnACemeterySection() {
		String check = underTest.getCemeterySection();
		assertEquals(CEMETERY_SECTION, check);
	}
}