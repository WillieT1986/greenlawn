package com.wrthompsonjr.greenlawn;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {

	@Resource
	private PersonRepository personRepo;

	@RequestMapping("/persons")
	public Iterable<Person> findPersons() {
		return personRepo.findAll();
	}

	@RequestMapping("/persons/{id}")
	public Person findPerson(@PathVariable(name = "id") long id) throws Exception {
		if (personRepo.getOne(id) == null) {
			throw new Exception("Person Not Found");
		}
		return personRepo.getOne(id);
	}

}
