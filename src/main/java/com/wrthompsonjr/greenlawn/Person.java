package com.wrthompsonjr.greenlawn;

public class Person {

	private String name;
	private String dateOfBirth;
	private String dateOfDeath;
	private String status;

	public Person(String name, String dateOfBirth, String dateOfDeath, String status, String string) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public String getDrescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
