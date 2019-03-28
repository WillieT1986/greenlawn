package com.wrthompsonjr.greenlawn;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {

//	@SuppressWarnings("unused")
//	private Logger log = LoggerFactory.getLogger(PersonRestController.class);

	@Resource
	private PersonRepository personRepo;

	@Resource
	private CemeterySectionRepository sectionRepo;

	@Resource
	private TagRepository tagRepo;

	@RequestMapping("/persons")
	public Iterable<Person> findPersons() {
		return personRepo.findAll();
	}

	@RequestMapping("/persons/{id}")
	public Person findPerson(@PathVariable(name = "id") long id) {
		if (personRepo.getOne(id) == null) {
			throw new CannotFindException("Person Not Found");
		}
		return personRepo.getOne(id);
	}

	@RequestMapping("/cemeterySections")
	public Iterable<CemeterySection> findCemeterySections() {
		return sectionRepo.findAll();
	}

	@RequestMapping("/cemeterySection/{id}")
	public CemeterySection findCemeterySection(@PathVariable(name = "id") long id) {
		if (sectionRepo.getOne(id) == null) {
			throw new CannotFindException("Cemetery Section Not Found");
		}
		return sectionRepo.getOne(id);
	}

	@RequestMapping("/tags")
	public Iterable<Tag> findTags() {
		return tagRepo.findAll();
	}

	@RequestMapping("/tag/{id}")
	public Tag findTag(@PathVariable(name = "id") long id) {
		if (tagRepo.getOne(id) == null) {
			throw new CannotFindException("Tag Not Found");
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