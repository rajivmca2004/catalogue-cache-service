package com.online.store.demo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.repository.CatalogueRepository;

/**
 * @author rasrivastava
 *
 */
@RestController
public class CatalogueController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private CatalogueRepository catalogueRepository;

	@Cacheable(value = "catalogues", key = "#id")
	@GetMapping("/catalogue/{id}")
	public Optional<Catalogue> fetchProduct(@PathVariable String id) {
		LOG.info("Getting user with ID {}.", id);
		return catalogueRepository.findById(Long.valueOf(id));
	}
}