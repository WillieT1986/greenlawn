package com.wrthompsonjr.greenlawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CemeterySectionTest {

	@Test
	public void shouldInstantiateCemeterySection() {
		CemeterySection underTest = new CemeterySection(0);
		assertNotNull(underTest);
	}

	@Test
	public void shouldConstructAndReturnACemeterySection() {
		CemeterySection underTest = new CemeterySection(101);
		int check = underTest.getCemeterySection();
		assertEquals(101, check);
	}

}
