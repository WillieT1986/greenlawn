package com.wrthompsonjr.greenlawn;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CemeterySection {

	@Id
	@GeneratedValue
	private long id;

	@OneToMany(mappedBy = "section")
	private Collection<Person> persons;

	private int cemeterySection;

	public CemeterySection() {
	}

	public CemeterySection(int cemeterySection) {
		this.cemeterySection = cemeterySection;
	}

	public int getCemeterySection() {
		return cemeterySection;
	}

	public long getId() {
		return id;
	}

	public Collection<Person> getPersons() {
		return persons;
	}

}
