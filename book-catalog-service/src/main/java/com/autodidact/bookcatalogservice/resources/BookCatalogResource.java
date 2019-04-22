package com.autodidact.bookcatalogservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.autodidact.bookcatalogservice.models.Book;
import com.autodidact.bookcatalogservice.models.CatalogItem;
import com.autodidact.bookcatalogservice.models.Rating;
import com.autodidact.bookcatalogservice.models.UserRatings;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		// Get all rated book ids
		//List<Rating> ratings = restTemplate.getForEntity("http://localhost:9092/userratings/" + userId, UserRatings.class).getBody().getRatings();
		
		//Using Eureka Service Discovery : Use the application names instead of the url and port : book-ratings-service
		List<Rating> ratings = restTemplate.getForEntity("http://book-ratings-service/userratings/" + userId, UserRatings.class).getBody().getRatings();
		
		// for each book id call book info service
		List<CatalogItem> catalogItemList = new ArrayList<>();
		for (Rating rating : ratings) {
			//ResponseEntity<Book> response = restTemplate.getForEntity("http://localhost:9091/books/" + rating.getBookId(), Book.class);
			
			//Using Eureka Service Discovery : Use the application names instead of the url and port : book-info-service
			ResponseEntity<Book> response = restTemplate.getForEntity("http://book-info-service/books/" + rating.getBookId(), Book.class);
			System.out.println(response.getBody());
			
			//Book book = restTemplate.getForObject("http://localhost:9091/books/" + rating.getBookId(), Book.class);
			
			//Using Eureka Service Discovery : Use the application names instead of the url and port : book-info-service
			Book book = restTemplate.getForObject("http://book-info-service/books/" + rating.getBookId(), Book.class);
			
			/*Book book = webClientBuilder.build()
							.get().uri("http://localhost:9091/books/" + rating.getBookId())
							.retrieve()
							.bodyToMono(Book.class)
							.block();*/

			catalogItemList.add(new CatalogItem(book.getName(), "Test", rating.getRating()));
		}
		return catalogItemList;
	}
}
