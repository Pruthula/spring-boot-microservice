package com.autodidact.bookcatalogservice.models;

import lombok.Data;

@Data
public class Rating {

	private String bookId;
	private double rating;

	public Rating () { }
	
	public Rating(String bookId, double rating) {
		super();
		this.bookId = bookId;
		this.rating = rating;
	}

}
