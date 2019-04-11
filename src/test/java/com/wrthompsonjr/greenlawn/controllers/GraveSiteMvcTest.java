package com.wrthompsonjr.greenlawn.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wrthompsonjr.greenlawn.data.CemeterySectionRepository;
import com.wrthompsonjr.greenlawn.data.GraveSiteRepository;
import com.wrthompsonjr.greenlawn.data.TagRepository;
import com.wrthompsonjr.greenlawn.models.CemeterySection;
import com.wrthompsonjr.greenlawn.models.GraveSite;
import com.wrthompsonjr.greenlawn.models.Tag;

@RunWith(SpringRunner.class)
@WebMvcTest(GraveSiteRestController.class)
public class GraveSiteMvcTest {

	@Resource
	MockMvc mvc;

	@MockBean
	private GraveSiteRepository graveSiteRepo;

	@MockBean
	private CemeterySectionRepository cemeterySectionRepo;

	@MockBean
	private TagRepository tagRepo;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldRetrieveIndividualGraveSite() throws Exception {
		when(graveSiteRepo.getOne(5L)).thenReturn(new GraveSite("", "Joe", "", "", "", "", "", "", "", "", null, ""));
		mvc.perform(get("/graveSites/5")).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFindGraveSiteId() throws Exception {
		mvc.perform(get("/graveSites/35")).andExpect(status().isNotFound());
	}

	@Test
	public void shouldRetrieveAnIndividualCemeterySection() throws Exception {
		when(cemeterySectionRepo.getOne(6L)).thenReturn(new CemeterySection("6"));
		mvc.perform(get("/cemeterySection/6")).andExpect(status().isOk());
	}

	@Test
	public void shouldFindCemeterySectionId() throws Exception {
		mvc.perform(get("/cemeterySections/36")).andExpect(status().isNotFound());
	}

	@Test
	public void shouldRetrieveTags() throws Exception {
		mvc.perform(get("/tags")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrieveAnIndividualTag() throws Exception {
		when(tagRepo.getOne(7L)).thenReturn(new Tag("7"));
		mvc.perform(get("/tag/7")).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFindATag() throws Exception {
		mvc.perform(get("/tags/37")).andExpect(status().isNotFound());
	}

}