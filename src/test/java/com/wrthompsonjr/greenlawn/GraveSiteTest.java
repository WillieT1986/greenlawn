package com.wrthompsonjr.greenlawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	private static final String TOMBSTONE_IMAGE_URL = "Tombstone Image";
	private static final String NAME_OF_PERSON = "name";
	private static final String US_STATE = "State";
	private static final String MILITARY_RANK = "Rank";
	private static final String MILITARY_BRANCH = "Branch";
	private static final String MILITARY_UNIT = "Unit";
	private static final String DATE_OF_BIRTH = "DOB";
	private static final String DATE_OF_DEATH = "DOD";
	private static final String STATUS = "Status";
	private static final String DESCRIPTION = "Description";
	private static final CemeterySection CEMETERY_SECTION = null;
	private static final String RELIGION = "Religion";

	Person underTest;

	@Before
	public void setUp() {
		underTest = new Person(TOMBSTONE_IMAGE_URL, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
				MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, DESCRIPTION, CEMETERY_SECTION, RELIGION);
	}

	@Test
	public void shouldInstantiateAPerson() {
		assertNotNull(underTest);
	}

	@Test
	public void shouldConstructAndReturnPersonName() {
		String check = underTest.getName();
		assertEquals(NAME_OF_PERSON, check);
	}

	@Test
	public void shouldReturnPersonDateOfBirth() {
		String check = underTest.getDateOfBirth();
		assertEquals(DATE_OF_BIRTH, check);
	}

	@Test
	public void shouldReturnPersonDateOfDeath() {
		String check = underTest.getDateOfDeath();
		assertEquals(DATE_OF_DEATH, check);
	}

	@Test
	public void shouldReturnPersonStatus() {
		String check = underTest.getStatus();
		assertEquals(STATUS, check);
	}

	@Test
	public void shouldReturnPersonDescription() {
		String check = underTest.getDrescription();
		assertEquals(DESCRIPTION, check);
	}

	@Test
	public void shouldAddReligionToPerson() {
		String check = underTest.getReligion();
		assertEquals(RELIGION, check);
	}

	@Test
	public void shouldAddTombstoneImageToPerson() {
		String check = underTest.getTombstoneImageUrl();
		assertEquals(TOMBSTONE_IMAGE_URL, check);
	}

	@Test
	public void shouldAddAUsStateToPerson() {
		String check = underTest.getUsState();
		assertEquals(US_STATE, check);
	}

	@Test
	public void shouldAddMilitaryRankToPerson() {
		String check = underTest.getMilitaryRank();
		assertEquals(MILITARY_RANK, check);
	}

	@Test
	public void shouldAddMilitaryBranchToPerson() {
		String check = underTest.getMilitaryBranch();
		assertEquals(MILITARY_BRANCH, check);
	}

	@Test
	public void shouldAddMilitaryUnitToPerson() {
		String check = underTest.getMilitaryUnit();
		assertEquals(MILITARY_UNIT, check);
	}
}