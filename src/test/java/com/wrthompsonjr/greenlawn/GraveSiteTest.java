package com.wrthompsonjr.greenlawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class GraveSiteTest {

	private static final String TOMBSTONE_IMAGE_URL = "Tombstone Image";
	private static final String NAME_OF_PERSON = "name";
	private static final String US_STATE = "State";
	private static final String MILITARY_RANK = "Rank";
	private static final String MILITARY_BRANCH = "Branch";
	private static final String MILITARY_UNIT = "Unit";
	private static final String DATE_OF_BIRTH = "DOB";
	private static final String DATE_OF_DEATH = "DOD";
	private static final String STATUS = "Status";
	private static final String OBITUARY = "Description";
	private static final CemeterySection CEMETERY_SECTION = null;
	private static final String RELIGION = "Religion";

	GraveSite underTest;

	@Before
	public void setUp() {
		underTest = new GraveSite(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
				MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION, RELIGION);
	}

	@Test
	public void shouldInstantiateAGraveSite() {
		assertNotNull(underTest);
	}

	@Test
	public void shouldConstructAndReturnTheNameOfAPersonInAGraveSite() {
		String check = underTest.getName();
		assertEquals(NAME_OF_PERSON, check);
	}

	@Test
	public void shouldReturnDateOfBirthOfAPersonInAGraveSite() {
		String check = underTest.getDateOfBirth();
		assertEquals(DATE_OF_BIRTH, check);
	}

	@Test
	public void shouldReturnDateOfDeathOfAPersonInAGraveSite() {
		String check = underTest.getDateOfDeath();
		assertEquals(DATE_OF_DEATH, check);
	}

	@Test
	public void shouldReturnTheStatusOfAPersonInAGraveSite() {
		String check = underTest.getStatus();
		assertEquals(STATUS, check);
	}

	@Test
	public void shouldReturnTheObituaryOfAPersonInAGraveSite() {
		String check = underTest.getObituary();
		assertEquals(OBITUARY, check);
	}

	@Test
	public void shouldAddReligionToThePersonInAGraveSite() {
		String check = underTest.getReligion();
		assertEquals(RELIGION, check);
	}

	@Test
	public void shouldAddTombstoneImageOfAPersonInAGraveSite() {
		String check = underTest.getTombstoneImageUrl();
		assertEquals(TOMBSTONE_IMAGE_URL, check);
	}

	@Test
	public void shouldAddAUsStateToThePersonOfAGraveSite() {
		String check = underTest.getUsState();
		assertEquals(US_STATE, check);
	}

	@Test
	public void shouldAddMilitaryRankToThePersonOfAGraveSite() {
		String check = underTest.getMilitaryRank();
		assertEquals(MILITARY_RANK, check);
	}

	@Test
	public void shouldAddMilitaryBranchToThePersonOfAGraveSite() {
		String check = underTest.getMilitaryBranch();
		assertEquals(MILITARY_BRANCH, check);
	}

	@Test
	public void shouldAddMilitaryUnitToThePersonOfAGraveSite() {
		String check = underTest.getMilitaryUnit();
		assertEquals(MILITARY_UNIT, check);
	}
}