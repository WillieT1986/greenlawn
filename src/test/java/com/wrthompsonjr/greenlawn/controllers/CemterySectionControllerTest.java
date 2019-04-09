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

import com.wrthompsonjr.greenlawn.data.CemeterySectionRepository;
import com.wrthompsonjr.greenlawn.models.CemeterySection;

public class CemterySectionControllerTest {

	@InjectMocks
	CemeterySectionController underTest;

	@Mock
	private CemeterySectionRepository cemeterySectionRepo;

	@Mock
	private CemeterySection cemeterySection1;

	@Mock
	private Model model;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddAnIndividualCemeterySectionToModel() {
		long cemeterySectionId = 2L;
		when(cemeterySectionRepo.getOne(cemeterySectionId)).thenReturn(cemeterySection1);
		underTest.findOneCemeterySection(cemeterySectionId, model);
		verify(model).addAttribute("cemeterySection", cemeterySection1);
	}

	@Test
	public void shouldReturnAnIndividualCemeterySectionToModel() {
		String template = underTest.findOneCemeterySection(2L, model);
		assertThat(template, is("cemeterySection"));
	}

}
