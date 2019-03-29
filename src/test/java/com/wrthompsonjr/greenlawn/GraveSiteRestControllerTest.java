package com.wrthompsonjr.greenlawn;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wrthompsonjr.greenlawn.GraveSiteRestController.CannotFindException;

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

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldRetrieveGraveSites() {
		when(graveSiteRepo.findAll()).thenReturn(Collections.singletonList(graveSite));
		Iterable<GraveSite> result = underTest.findGraveSites();
		assertThat(result, contains(any(GraveSite.class)));
	}

	@Test
	public void shouldGetGraveSitesFromDatabase() {
		when(graveSiteRepo.findAll()).thenReturn(Collections.singletonList(graveSite));
		Iterable<GraveSite> result = underTest.findGraveSites();
		assertThat(result, contains(graveSite));
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
		Iterable<CemeterySection> result = underTest.findCemeterySections();
		assertThat(result, contains(any(CemeterySection.class)));
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
		Iterable<Tag> result = underTest.findTags();
		assertThat(result, contains(any(Tag.class)));
	}

	@Test
	public void shouldReturnAnIndividualTagFromDatabase() {
		when(tagRepo.getOne(183L)).thenReturn(tag);
		Tag result = underTest.findTag(183L);
		assertThat(result, is(tag));
	}
}