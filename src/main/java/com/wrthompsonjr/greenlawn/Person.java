package com.wrthompsonjr.greenlawn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private long id;

	@Lob
	private String name;
	private String dateOfBirth;
	private String dateOfDeath;
	private String status;
	private String description;

	public Person() {
	}

	public Person(String name, String dateOfBirth, String dateOfDeath, String status, String description) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
		this.status = status;
		this.description = description;
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
		return description;
	}

	public long getId() {
		return id;
	}

}