package com.autodidact.bookinfoservice.models;

import lombok.Data;

@Data
public class Book {

	private String bookId;
	private String name;

	public Book(String bookId, String name) {
		super();
		this.bookId = bookId;
		this.name = name;
	}
}
