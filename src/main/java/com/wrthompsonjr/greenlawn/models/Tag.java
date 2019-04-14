package com.wrthompsonjr.greenlawn.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;

	@ManyToMany(mappedBy = "tags")
	private Collection<GraveSite> graveSites;

	private String tagName;

	public Tag() {
	}

	public Tag(String tagName) {
		this.tagName = tagName;
	}

	public Collection<GraveSite> getGraveSites() {
		return graveSites;
	}

	public String getTag() {
		return tagName;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return tagName;
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
		return id == ((Tag) obj).id;
	}
}