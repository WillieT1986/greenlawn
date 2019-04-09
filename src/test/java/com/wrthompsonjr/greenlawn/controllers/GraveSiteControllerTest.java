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

import com.wrthompsonjr.greenlawn.data.GraveSiteRepository;
import com.wrthompsonjr.greenlawn.models.GraveSite;

public class GraveSiteControllerTest {

	@InjectMocks
	GraveSiteController underTest;

	@Mock
	private GraveSiteRepository graveSiteRepo;

	@Mock
	private GraveSite graveSite1;

	@Mock
	private Model model;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddAnIndividualGraveSiteToModel() {
		long graveSiteId = 1L;
		when(graveSiteRepo.getOne(graveSiteId)).thenReturn(graveSite1);
		underTest.findOneGraveSite(graveSiteId, model);
		verify(model).addAttribute("graveSite", graveSite1);
	}

	@Test
	public void shouldReturnAnIndividualGraveSite() {
		String template = underTest.findOneGraveSite(1L, model);
		assertThat(template, is("graveSite"));
	}
}