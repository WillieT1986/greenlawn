package com.wrthompsonjr.greenlawn;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private CemeterySection section;

	@ManyToMany
	private Collection<Tag> tags;

	@Lob
	private String name;
	private String dateOfBirth;
	private String dateOfDeath;
	private String status;
	private String description;
	private String religion;

	public Person() {
	}

	public Person(String name, String dateOfBirth, String dateOfDeath, String status, String description,
			CemeterySection cemeterySection, String religion, Tag... tags) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
		this.status = status;
		this.description = description;
		this.section = cemeterySection;
		this.religion = religion;
		this.tags = new HashSet<>(asList(tags));
	}

	public Collection<Tag> getTags() {
		return tags;
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

	public String getReligion() {
		return religion;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Person) obj).id;
	}

}