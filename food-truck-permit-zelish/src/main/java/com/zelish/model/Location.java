package com.zelish.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class Location {

	@Column(name = "TYPE")
	private String type;

	@ElementCollection
	@Column(name = "COORDINATES")
	private List<Integer> coordinates = new ArrayList<Integer>();

	public Location() {
	}

	public Location(String type, List<Integer> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Integer> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Integer> coordinates) {
		this.coordinates = coordinates;
	}

}
