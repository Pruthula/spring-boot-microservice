package com.autodidact.bookcatalogservice.models;

import lombok.Data;

@Data
public class Book {

	private String bookId;
	private String name;

	public Book () { }

	public Book(String bookId, String name) {
		super();
		this.bookId = bookId;
		this.name = name;
	}
}
