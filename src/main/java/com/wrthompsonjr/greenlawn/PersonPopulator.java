package com.wrthompsonjr.greenlawn;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonPopulator implements CommandLineRunner {

	@Resource
	PersonRepository personRepo;

	@Resource
	CemeterySectionRepository sectionRepo;

	private CemeterySection createCemeterySection(String cemeterySectionArea) {
		CemeterySection z = new CemeterySection(cemeterySectionArea);
		return sectionRepo.save(z);
	}

	@Override
	public void run(String... args) throws Exception {

		CemeterySection sectionA = createCemeterySection("101");

	}

}
