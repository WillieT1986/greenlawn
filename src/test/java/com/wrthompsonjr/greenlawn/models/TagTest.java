package com.wrthompsonjr.greenlawn.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.wrthompsonjr.greenlawn.models.Tag;

public class TagTest {

	private static final String TAG = "Name";

	Tag underTest;

	@Before
	public void shouldsetUp() {
		underTest = new Tag(TAG);
	}

	@Test
	public void shouldConstructAndReturnTagName() {
		String check = underTest.getTag();
		assertEquals(TAG, check);
	}
}