package com.autodidact.bookratingsservice.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autodidact.bookratingsservice.model.Rating;

@RestController
@RequestMapping("ratings")
public class RatingsResource {

	@RequestMapping("{bookId}")
	public Rating getRating(@PathVariable("bookId") String bookId) {
		Map<String, Rating> catalog = new HashMap<>();
		catalog.put("4", new Rating("4", 3.5));
		catalog.put("9", new Rating("9", 4.5));
		
		return catalog.get(bookId);
	}
}
