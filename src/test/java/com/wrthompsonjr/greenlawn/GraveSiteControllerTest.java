package com.wrthompsonjr.greenlawn;

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

public class GraveSiteControllerTest {

	@InjectMocks
	GraveSiteController underTest;

	@Mock
	private GraveSiteRepository graveSiteRepo;

	@Mock
	private CemeterySectionRepository cemeterySectionRepo;

	@Mock
	private GraveSite graveSite1;

	@Mock
	private CemeterySection cemeterySection1;

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
