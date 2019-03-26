package com.wrthompsonjr.greenlawn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;

	private String tagName;

	public Tag() {
	}

	public Tag(String tagName) {
		this.tagName = tagName;
	}

	public String getTag() {
		return tagName;
	}

	public long getId() {
		return id;
	}

}
