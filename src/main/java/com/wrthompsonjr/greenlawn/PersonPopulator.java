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

	@Resource
	TagRepository tagRepo;

	private CemeterySection createCemeterySection(String cemeterySectionArea) {
		CemeterySection z = new CemeterySection(cemeterySectionArea);
		return sectionRepo.save(z);
	}

	private Tag createTag(String tagName) {
		Tag t = new Tag(tagName);
		return tagRepo.save(t);
	}

	@Override
	public void run(String... args) throws Exception {

		CemeterySection sectionA = createCemeterySection("123B"); // Civilians
		CemeterySection sectionB = createCemeterySection("28"); // Veterans

		Tag tagOne = createTag("WWI");
		Tag tagTwo = createTag("WWII");
		Tag tagThree = createTag("Spanish American War");
		Tag tagFour = createTag("Civilian");

		// 10 sample Civilians
		personRepo.save(new Person("John A Doe", "01/15/1965", "12/15/2015", "", "No Summary At This Time...", sectionA,
				tagFour));

	}

}
