package com.wrthompsonjr.greenlawn.models;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class GraveSite {

	@Id
	@GeneratedValue
	private long id;

	@JsonIgnore
	@ManyToOne
	private CemeterySection cemeterySection;

	@JsonIgnore
	@ManyToMany
	private Collection<Tag> tags;

	@Lob
	private String obituary;
	private String tombstoneImageUrl;
	private String regularImageUrl;
	private String name;
	private String usState;
	private String militaryRank;
	private String militaryBranch;
	private String militaryUnit;
	private String dateOfBirth;
	private String dateOfDeath;
	private String status;
	private String religion;
	private String militaryMedal;
	private String gpsCoordinates;

	public GraveSite() {
	}

	public GraveSite(String tombstoneImageUrl, String regularImageUrl, String name, String usState, String militaryRank,
			String militaryBranch, String militaryUnit, String dateOfBirth, String dateOfDeath, String status,
			String obituary, CemeterySection cemeterySection, String religion, String militaryMedal,
			String gpsCoordinates, Tag... tags) {
		this.tombstoneImageUrl = tombstoneImageUrl;
		this.regularImageUrl = regularImageUrl;
		this.name = name;
		this.usState = usState;
		this.militaryRank = militaryRank;
		this.militaryBranch = militaryBranch;
		this.militaryUnit = militaryUnit;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
		this.status = status;
		this.obituary = obituary;
		this.cemeterySection = cemeterySection;
		this.religion = religion;
		this.militaryMedal = militaryMedal;
		this.gpsCoordinates = gpsCoordinates;
		this.tags = new HashSet<>(asList(tags));
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public String getTombstoneImageUrl() {
		return tombstoneImageUrl;
	}

	public String getRegularImageUrl() {
		return regularImageUrl;
	}

	public String getName() {
		return name;
	}

	public String getUsState() {
		return usState;
	}

	public String getMilitaryRank() {
		return militaryRank;
	}

	public String getMilitaryBranch() {
		return militaryBranch;
	}

	public String getMilitaryUnit() {
		return militaryUnit;
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

	public String getObituary() {
		return obituary;
	}

	public String getReligion() {
		return religion;
	}

	public String getMilitaryMedal() {
		return militaryMedal;
	}

	public String getGpsCoordinates() {
		return gpsCoordinates;
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
		return id == ((GraveSite) obj).id;
	}
}