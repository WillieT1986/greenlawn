package com.wrthompsonjr.greenlawn.controllers;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wrthompsonjr.greenlawn.data.CemeterySectionRepository;
import com.wrthompsonjr.greenlawn.data.GraveSiteRepository;
import com.wrthompsonjr.greenlawn.data.TagRepository;
import com.wrthompsonjr.greenlawn.models.CemeterySection;
import com.wrthompsonjr.greenlawn.models.GraveSite;
import com.wrthompsonjr.greenlawn.models.Tag;

@RestController
public class GraveSiteRestController {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(GraveSiteRestController.class);

	@Resource
	private GraveSiteRepository graveSiteRepo;

	@Resource
	private CemeterySectionRepository cemeterySectionRepo;

	@Resource
	private TagRepository tagRepo;

	@RequestMapping("/graveSites")
	public String findGraveSites(Model model) {
		model.addAttribute("graveSites", graveSiteRepo.findAll());
		return "graveSites";
	}

	@RequestMapping("/graveSites/{id}")
	public GraveSite findGraveSite(@PathVariable(name = "id") Long id) {
		if (graveSiteRepo.getOne(id) == null) {
			throw new CannotFindException("Unable To Find. Grave Site Not Found.");
		}
		return graveSiteRepo.getOne(id);
	}

	@RequestMapping("/graveSite/{id}")
	public Iterable<GraveSite> findGraveSiteByCemeterySectionId(@PathVariable(name = "id") Long id) {
		return cemeterySectionRepo.getOne(id).getGraveSites();
	}

	public Iterable<GraveSite> findGraveSiteByCemeterySection(String cemeterySection) {
		return cemeterySectionRepo.findOneByCemeterySection(cemeterySection).getGraveSites();
	}

	@RequestMapping("/cemeterySections/{id}")
	public CemeterySection findCemeterySection(@PathVariable(name = "id") Long id) {
		if (cemeterySectionRepo.getOne(id) == null) {
			throw new CannotFindException("Unable To Find. Cemetery Section Not Found.");
		}
		return cemeterySectionRepo.getOne(id);
	}

	public String findCemeterySections(Model model) {
		model.addAttribute("cemeterySections", cemeterySectionRepo.findAll());
		return "cemeterySections";
	}

	@RequestMapping("/cemeterySection/{id}")
	public String findCemeterySectionByCemeterySectionId(@PathVariable(name = "id") Long id) {
		return cemeterySectionRepo.getOne(id).getCemeterySection();
	}

	public String findCemeterySectionByCemeterySection(String cemeterySectionArea) {
		return cemeterySectionRepo.findOneByCemeterySection(cemeterySectionArea).getCemeterySection();
	}

	@RequestMapping("/tags")
	public Iterable<Tag> findTags() {
		return tagRepo.findAll();
	}

	@RequestMapping("/tag/{id}")
	public Tag findTag(@PathVariable(name = "id") Long id) {
		if (tagRepo.getOne(id) == null) {
			throw new CannotFindException("Unable To Find. Tag Not Found.");
		}
		return tagRepo.getOne(id);
	}

	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class CannotFindException extends RuntimeException {
		private String message;

		public String getMessage() {
			return message;
		}

		CannotFindException(String errorMessage) {
			this.message = errorMessage;
		}
	}

}