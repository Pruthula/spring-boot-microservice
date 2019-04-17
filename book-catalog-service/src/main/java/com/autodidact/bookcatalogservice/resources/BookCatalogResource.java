package com.autodidact.bookcatalogservice.resources;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autodidact.bookcatalogservice.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		Map<String, List<CatalogItem>> catalog = new HashMap<>();
		catalog.put("Ramesh", Collections.singletonList(
				new CatalogItem("House Of Cards", "", 4)
		));
		catalog.put("Suresh", Collections.singletonList(
				new CatalogItem("Master Of the Game", "", 9)
		));
		
		return catalog.get(userId);
	}
}
