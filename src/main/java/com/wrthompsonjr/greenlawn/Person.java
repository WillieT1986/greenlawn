package com.wrthompsonjr.greenlawn;

public class Person {

	private String name;
	private String dateOfBirth;
	private String dateOfDeath;

	public Person(String name, String dateOfBirth, String dateOfDeath) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
	}

	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getDateOfDeath() {
		return dateOfDeath;
	}

}
