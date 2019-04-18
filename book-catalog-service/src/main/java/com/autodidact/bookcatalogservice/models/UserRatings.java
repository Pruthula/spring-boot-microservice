package com.autodidact.bookcatalogservice.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserRatings {

	private List<Rating> ratings = new ArrayList<>();

	public UserRatings(List<Rating> ratings) {
		super();
		this.ratings = ratings;
	}
	
	public UserRatings() { }
}
