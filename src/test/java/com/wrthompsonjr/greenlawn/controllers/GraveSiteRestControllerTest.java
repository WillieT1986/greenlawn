package com.wrthompsonjr.greenlawn.controllers;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.wrthompsonjr.greenlawn.controllers.GraveSiteRestController.CannotFindException;
import com.wrthompsonjr.greenlawn.data.CemeterySectionRepository;
import com.wrthompsonjr.greenlawn.data.GraveSiteRepository;
import com.wrthompsonjr.greenlawn.data.TagRepository;
import com.wrthompsonjr.greenlawn.models.CemeterySection;
import com.wrthompsonjr.greenlawn.models.GraveSite;
import com.wrthompsonjr.greenlawn.models.Tag;

public class GraveSiteRestControllerTest {

	@InjectMocks
	private GraveSiteRestController underTest;

	@Mock
	private GraveSite graveSite;

	@Mock
	private CemeterySection cemeterySection;

	@Mock
	private Tag tag;

	@Mock
	private GraveSiteRepository graveSiteRepo;

	@Mock
	private CemeterySectionRepository cemeterySectionRepo;

	@Mock
	private TagRepository tagRepo;

	@Mock
	private Collection<GraveSite> graveSites;

	@Mock
	Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldRetrieveGraveSites() {
		when(graveSiteRepo.findAll()).thenReturn(Collections.singletonList(graveSite));
		String result = underTest.findGraveSites(model);
		assertTrue(result, contains(any(GraveSite.class)) != null);
	}

	@Test
	public void shouldGetGraveSitesFromDatabase() {
		when(graveSiteRepo.findAll()).thenReturn(Collections.singletonList(graveSite));
		String result = underTest.findGraveSites(model);
		assertTrue(result, contains(graveSite) != null);
	}

	@Test
	public void shouldReturnAnIndividualGraveSiteFromDatabase() {
		when(graveSiteRepo.getOne(130000L)).thenReturn(graveSite);
		GraveSite result = underTest.findGraveSite(130000L);
		assertThat(result, is(graveSite));
	}

	@Test(expected = CannotFindException.class)
	public void shouldReturnCannotFindExceptionForPersonId() {
		long invalidPersonId = 36L;
		underTest.findGraveSite(invalidPersonId);
	}

	@Test
	public void shouldReturnAListOfCemeterySections() {
		when(cemeterySectionRepo.findAll()).thenReturn(Collections.singletonList(cemeterySection));
		String result = underTest.findCemeterySections(model);
		assertTrue(result, contains(any(CemeterySection.class)) != null);
	}

	@Test
	public void shouldReturnAnIndividualCemeterySectionFromDatabase() {
		when(cemeterySectionRepo.getOne(88L)).thenReturn(cemeterySection);
		CemeterySection result = underTest.findCemeterySection(88L);
		assertThat(result, is(cemeterySection));
	}

	@Test
	public void shouldReturnAListOfTags() {
		when(tagRepo.findAll()).thenReturn(Collections.singletonList(tag));
		String result = underTest.findTags(model);
		assertTrue(result, contains(any(Tag.class)) != null);
	}

	@Test
	public void shouldReturnAnIndividualTagFromDatabase() {
		when(tagRepo.getOne(183L)).thenReturn(tag);
		Tag result = underTest.findTag(183L);
		assertThat(result, is(tag));
	}

	@Test
	public void shouldReturnListOfGraveSitesForGivenCemeterySection() {
		Long cemeterySectionId = 123L;
		when(cemeterySectionRepo.getOne(cemeterySectionId)).thenReturn(cemeterySection);
		when(cemeterySection.getGraveSites()).thenReturn(Collections.singleton(graveSite));
		Iterable<GraveSite> result = underTest.findGraveSiteByCemeterySectionId(cemeterySectionId);
		assertThat(result, contains(graveSite));
	}

	@Test
	public void shouldReturnAnyGraveSiteForGivenCemeterySection() {
		when(cemeterySectionRepo.findOneByCemeterySection("88A")).thenReturn(cemeterySection);
		when(cemeterySection.getGraveSites()).thenReturn(Collections.singleton(graveSite));
		Iterable<GraveSite> result = underTest.findGraveSiteByCemeterySection("88A");
		assertThat(result, contains(graveSite));
	}

}