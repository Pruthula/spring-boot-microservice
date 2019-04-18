package com.autodidact.bookcatalogservice.models;

import lombok.Data;

@Data
public class CatalogItem {

	private String name;
	private String desc;
	private double rating;

	public CatalogItem(String name, String desc, double rating) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}

}
