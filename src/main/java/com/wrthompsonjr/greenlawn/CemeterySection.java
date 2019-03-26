package com.wrthompsonjr.greenlawn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CemeterySection {

	@Id
	@GeneratedValue
	private long id;

	@Lob
	private int cemeterySection;

	public CemeterySection(int cemeterySection) {
		this.cemeterySection = cemeterySection;
	}

	public int getCemeterySection() {
		return cemeterySection;
	}

	public long getId() {
		return id;
	}

}
