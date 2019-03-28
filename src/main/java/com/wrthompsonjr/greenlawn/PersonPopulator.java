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
		personRepo.save(new Person("John B Doe", "02/15/1975", "01/15/2016", "", "No Summary At This Time...", sectionA,
				tagFour));
		personRepo.save(new Person("John C Doe", "03/15/1985", "02/15/2017", "", "No Summary At This Time...", sectionA,
				tagFour));
		personRepo.save(new Person("John D Doe", "04/15/1945", "03/15/2018", "", "No Summary At This Time...", sectionA,
				tagFour));
		personRepo.save(new Person("John E Doe", "05/15/1995", "04/15/2019", "", "No Summary At This Time...", sectionA,
				tagFour));
		personRepo.save(new Person("Jane A Doe", "01/15/1965", "05/15/2016", "", "No Summary At This Time...", sectionA,
				tagFour));
		personRepo.save(new Person("Jane B Doe", "01/15/1966", "06/15/2017", "", "No Summary At This Time...", sectionA,
				tagFour));
		personRepo.save(new Person("Jane C Doe", "01/15/1967", "07/15/2018", "", "No Summary At This Time...", sectionA,
				tagFour));
		personRepo.save(new Person("Jane D Doe", "01/15/1968", "08/15/2019", "", "No Summary At This Time...", sectionA,
				tagFour));
		personRepo.save(new Person("Jane E Doe", "01/15/1969", "09/15/2011", "", "No Summary At This Time...", sectionA,
				tagFour));

		// 10 sample Military
		personRepo.save(
				new Person("Jody A Gotyou", "1895", "1920", "Veteran", "No Summary At This Time...", sectionB, tagOne));
		personRepo.save(
				new Person("Jody B GotMe", "1910", "1944", "Veteran", "No Summary At This Time...", sectionB, tagTwo));
		personRepo.save(new Person("Johnny C Oorah", "1874", "1957", "Veteran", "No Summary At This Time...", sectionB,
				tagThree));
		personRepo.save(new Person("Johnny D Hoohah", "1891", "1955", "Veteran", "No Summary At This Time...", sectionB,
				tagOne, tagTwo));
		personRepo.save(new Person("Johnny E Schmukatelli", "1921", "1955", "Veteran", "No Summary At This Time...",
				sectionB, tagTwo));
	}

}
