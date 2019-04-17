package com.autodidact.bookinfoservice.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autodidact.bookinfoservice.models.Book;

@RestController
@RequestMapping("/books")
public class BookResource {

	@RequestMapping("{bookId}")
	public Book getBookInfo(@PathVariable("bookId") String bookId) {
		Map<String, Book> catalog = new HashMap<>();
		catalog.put("4", new Book("4", "House Of Cards"));
		catalog.put("9", new Book("9", "Master Of the Game"));
		
		return catalog.get(bookId);
	}
}
