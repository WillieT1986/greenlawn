package com.wrthompsonjr.greenlawn;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	public Iterable<GraveSite> findGraveSites() {
		return graveSiteRepo.findAll();
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

	@RequestMapping("/cemeterySections")
	public Iterable<CemeterySection> findCemeterySections() {
		return cemeterySectionRepo.findAll();
	}

	@RequestMapping("/cemeterySections/{id}")
	public CemeterySection findCemeterySection(@PathVariable(name = "id") Long id) {
		if (cemeterySectionRepo.getOne(id) == null) {
			throw new CannotFindException("Unable To Find. Cemetery Section Not Found.");
		}
		return cemeterySectionRepo.getOne(id);
	}

	@RequestMapping("/cemeterySection/{id}")
	public String findCemeterySectionByCemeterySectionId(@PathVariable(name = "id") Long id) {
		return cemeterySectionRepo.getOne(id).getCemeterySection();
	}

	public String findCemeterySectionByCemeterySection(String cemeterySection) {
		return cemeterySectionRepo.findOneByCemeterySection(cemeterySection).getCemeterySection();
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