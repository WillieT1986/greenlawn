package com.wrthompsonjr.greenlawn;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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

	@Test
	public void shouldRetrieveGraveSites() throws Exception {
		mvc.perform(get("/graveSites")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrieveIndividualGraveSite() throws Exception {
		when(graveSiteRepo.getOne(1L)).thenReturn(new GraveSite("", "Joe", "", "", "", "", "", "", "", "", null, ""));
		mvc.perform(get("/graveSites/1")).andExpect(status().isOk());
	}

}