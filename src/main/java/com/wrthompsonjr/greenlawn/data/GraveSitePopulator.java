package com.wrthompsonjr.greenlawn.data;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wrthompsonjr.greenlawn.models.CemeterySection;
import com.wrthompsonjr.greenlawn.models.GraveSite;
import com.wrthompsonjr.greenlawn.models.Tag;

@Component
public class GraveSitePopulator implements CommandLineRunner {

	@Resource
	GraveSiteRepository graveSiteRepo;

	@Resource
	CemeterySectionRepository cemeterySectionRepo;

	@Resource
	TagRepository tagRepo;

	private CemeterySection createCemeterySection(String cemeterySectionArea) {
		CemeterySection section = new CemeterySection(cemeterySectionArea);
		return cemeterySectionRepo.save(section);
	}

	private Tag createTag(String tagName) {
		Tag t = new Tag(tagName);
		return tagRepo.save(t);
	}

	@Override
	public void run(String... args) throws Exception {

		CemeterySection sectionA = createCemeterySection("123-B"); // Civilians
		CemeterySection sectionB = createCemeterySection("28"); // Veterans

		Tag tagOne = createTag("WWI");
		Tag tagTwo = createTag("WWII");
		Tag tagThree = createTag("Spanish American War");
		Tag tagFour = createTag("Civilian");

		// 10 sample Civilians
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"John A Doe", "", "", "", "", "01/15/1965", "12/15/2015", "", "No Summary At This Time...", sectionA,
				"Christian", "", "", tagFour));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"John B Doe", "", "", "", "", "02/15/1975", "01/15/2016", "", "No Summary At This Time...", sectionA,
				"Christian", "", "", tagFour));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"John C Doe", "", "", "", "", "03/15/1985", "02/15/2017", "", "No Summary At This Time...", sectionA,
				"Christian", "", "", tagFour));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"John D Doe", "", "", "", "", "04/15/1945", "03/15/2018", "", "No Summary At This Time...", sectionA,
				"Christian", "", "", tagFour));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"John E Doe", "", "", "", "", "05/15/1995", "04/15/2019", "", "No Summary At This Time...", sectionA,
				"Christian", "", "", tagFour));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Jane A Doe", "", "", "", "", "01/15/1965", "05/15/2016", "", "No Summary At This Time...", sectionA,
				"Christian", "", "", tagFour));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Jane B Doe", "", "", "", "", "01/15/1966", "06/15/2017", "", "No Summary At This Time...", sectionA,
				"Christian", "", "", tagFour));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Jane C Doe", "", "", "", "", "01/15/1967", "07/15/2018", "", "No Summary At This Time...", sectionA,
				"Christian", "", "", tagFour));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Jane D Doe", "", "", "", "", "01/15/1968", "08/15/2019", "", "No Summary At This Time...", sectionA,
				"Christian", "", "", tagFour));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Jane E Doe", "", "", "", "", "01/15/1969", "09/15/2011", "", "No Summary At This Time...", sectionA,
				"", "", "", tagFour));

		// 10 sample Military
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "", "Jody A Gotyou", "",
				"Military Rank", "", "Military Unit", "1895", "1920", "Veteran", "No Summary At This Time...", sectionB,
				"Christian", "", "", tagOne));
		graveSiteRepo.save(
				new GraveSite("./images/tombstone/place-holder.jpg", "", "Jody B GotMe", "", "", "Military Branch", "",
						"1910", "1944", "Veteran", "No Summary At This Time...", sectionB, "Religion", "", "", tagTwo));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Johnny C Oorah", "State", "Military Rank", "", "Military Unit", "1874", "1957", "Veteran",
				"No Summary At This Time...", sectionB, "Christian", "", "", tagThree));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Johnny D Hoohah", "State", "Military Rank", "Military Branch", "", "1891", "1955", "Veteran",
				"No Summary At This Time...", sectionB, "Christian", "Purple Heart", "", tagOne, tagTwo));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Johnny E Schmukatelli", "State", "Military Rank", "Military Branch", "", "1921", "1955", "Veteran",
				"No Summary At This Time...", sectionB, "Christian", "", "", tagTwo));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Jane A Dane", "State", "Military Rank", "Military Branch", "", "1900", "1950", "Veteran",
				"No Summary At This Time...", sectionB, "Christian", "", "", tagTwo));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Jane B Dane", "State", "Military Rank", "", "Military Unit", "1900", "1944", "Veteran",
				"No Summary At This Time...", sectionB, "Christian", "", "", tagTwo));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Barbie C Oorah", "State", "Military Rank", "Military Branch", "", "1895", "1957", "Veteran",
				"No Summary At This Time...", sectionB, "Christian", "", "", tagTwo));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "./images/tombstone/place-holder-2.jpg",
				"Barbie D Hoohah", "State", "Military Rank", "Military Branch", "Military Unit", "1901", "1955",
				"Veteran", "No Summary At This Time...", sectionB, "", "", "", tagTwo));
		graveSiteRepo.save(new GraveSite("./images/tombstone/place-holder.jpg", "", "Barbie E Schmukatelli", "Ohio",
				"Lance Corporal", "", "2/2 Fox Co.", "1921", "1955", "Veteran",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n"
						+ "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\n"
						+ "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\n"
						+ "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\n"
						+ "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\n"
						+ "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
				sectionB, "Religion", "Purple Heart", "https://maps.google.com", tagTwo));
	}
}