package com.wrthompsonjr.greenlawn.controllers;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.wrthompsonjr.greenlawn.data.TagRepository;
import com.wrthompsonjr.greenlawn.models.Tag;

public class TagControllerTest {

	@InjectMocks
	TagController underTest;

	@Mock
	private TagRepository tagRepo;

	@Mock
	private Tag tag1;

	@Mock
	private Model model;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddAnTagToModel() {
		long tagId = 3L;
		when(tagRepo.getOne(tagId)).thenReturn(tag1);
		underTest.findOneTag(tagId, model);
		verify(model).addAttribute("tag", tag1);
	}

	@Test
	public void shouldReturnAnIndividualTagToModel() {
		String template = underTest.findOneTag(3L, model);
		assertThat(template, is("tag"));
	}
}