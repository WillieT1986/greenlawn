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
		personRepo.save(new Person("tombstoneImageUrl", "John A Doe", "State", "", "", "01/15/1965", "12/15/2015", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));
		personRepo.save(new Person("tombstoneImageUrl", "John B Doe", "State", "", "", "02/15/1975", "01/15/2016", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));
		personRepo.save(new Person("tombstoneImageUrl", "John C Doe", "State", "", "", "03/15/1985", "02/15/2017", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));
		personRepo.save(new Person("tombstoneImageUrl", "John D Doe", "State", "", "", "04/15/1945", "03/15/2018", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));
		personRepo.save(new Person("tombstoneImageUrl", "John E Doe", "State", "", "", "05/15/1995", "04/15/2019", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));
		personRepo.save(new Person("tombstoneImageUrl", "Jane A Doe", "State", "", "", "01/15/1965", "05/15/2016", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));
		personRepo.save(new Person("tombstoneImageUrl", "Jane B Doe", "State", "", "", "01/15/1966", "06/15/2017", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));
		personRepo.save(new Person("tombstoneImageUrl", "Jane C Doe", "State", "", "", "01/15/1967", "07/15/2018", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));
		personRepo.save(new Person("tombstoneImageUrl", "Jane D Doe", "State", "", "", "01/15/1968", "08/15/2019", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));
		personRepo.save(new Person("tombstoneImageUrl", "Jane E Doe", "State", "", "", "01/15/1969", "09/15/2011", "",
				"", "No Summary At This Time...", sectionA, "Religion", tagFour));

		// 10 sample Military
		personRepo.save(new Person("tombstoneImageUrl", "Jody A Gotyou", "State", "Military Rank", "Military Branch",
				"Military Unit", "1895", "1920", "Veteran", "No Summary At This Time...", sectionB, "Religion",
				tagOne));
		personRepo.save(new Person("tombstoneImageUrl", "Jody B GotMe", "State", "Military Rank", "Military Branch",
				"Military Unit", "1910", "1944", "Veteran", "No Summary At This Time...", sectionB, "Religion",
				tagTwo));
		personRepo.save(new Person("tombstoneImageUrl", "Johnny C Oorah", "State", "Military Rank", "Military Branch",
				"Military Unit", "1874", "1957", "Veteran", "No Summary At This Time...", sectionB, "Religion",
				tagThree));
		personRepo.save(new Person("tombstoneImageUrl", "Johnny D Hoohah", "State", "Military Rank", "Military Branch",
				"Military Unit", "1891", "1955", "Veteran", "No Summary At This Time...", sectionB, "Religion", tagOne,
				tagTwo));
		personRepo.save(new Person("tombstoneImageUrl", "Johnny E Schmukatelli", "State", "Military Rank",
				"Military Branch", "Military Unit", "1921", "1955", "Veteran", "No Summary At This Time...", sectionB,
				"Religion", tagTwo));
		personRepo.save(new Person("tombstoneImageUrl", "Jane A Dane", "State", "Military Rank", "Military Branch",
				"Military Unit", "1900", "1950", "Veteran", "No Summary At This Time...", sectionB, "Religion",
				tagTwo));
		personRepo.save(new Person("tombstoneImageUrl", "Jane B Dane", "State", "Military Rank", "Military Branch",
				"Military Unit", "1900", "1944", "Veteran", "No Summary At This Time...", sectionB, "Religion",
				tagTwo));
		personRepo.save(new Person("tombstoneImageUrl", "Barbie C Oorah", "State", "Military Rank", "Military Branch",
				"Military Unit", "1895", "1957", "Veteran", "No Summary At This Time...", sectionB, "Religion",
				tagTwo));
		personRepo.save(new Person("tombstoneImageUrl", "Barbie D Hoohah", "State", "Military Rank", "Military Branch",
				"Military Unit", "1901", "1955", "Veteran", "No Summary At This Time...", sectionB, "Religion",
				tagTwo));
		personRepo.save(new Person("tombstoneImageUrl", "Barbie E Schmukatelli", "State", "Military Rank",
				"Military Branch", "Military Unit", "1921", "1955", "Veteran", "No Summary At This Time...", sectionB,
				"Religion", tagTwo));
	}
}