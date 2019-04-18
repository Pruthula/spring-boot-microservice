package com.autodidact.bookratingsservice.resource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autodidact.bookratingsservice.model.Rating;
import com.autodidact.bookratingsservice.model.UserRatings;

@RestController
public class RatingsResource {

	@RequestMapping("bookratings/{bookId}")
	public Rating getRating(@PathVariable("bookId") String bookId) {
		Map<String, Rating> catalog = new HashMap<>();
		catalog.put("4", new Rating("4", 3.5));
		catalog.put("9", new Rating("9", 4.5));
		
		return catalog.get(bookId);
	}
	
	@RequestMapping("userratings/{userId}")
	public UserRatings getRatings(@PathVariable("userId") String userId) {
		Map<String, UserRatings> catalog = new HashMap<>();
		
		catalog.put("Ramesh", new UserRatings());
		catalog.put("Suresh", new UserRatings());
		
		catalog.get("Ramesh").getRatings().addAll(Arrays.asList(
				new Rating("4", 3.5),
				new Rating("9", 4.5)
		));

		catalog.get("Suresh").getRatings().addAll(Arrays.asList(
				new Rating("4", 3),
				new Rating("9", 4)
		));
		return catalog.get(userId);
	}
}
