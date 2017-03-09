package com.pskindero.spring.rest_boot.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pskindero.spring.rest_boot.domain.Book;
import com.pskindero.spring.rest_boot.services.BooksService;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BooksController.class);
	
	private BooksService booksService;

	@Autowired
	public BooksController(BooksService service) {
		this.booksService = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Book>> getAll() {	
		LOGGER.info("Request method: {}", RequestMethod.GET);
		return new ResponseEntity<List<Book>>(booksService.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", 
					method = RequestMethod.GET)
	public ResponseEntity<?> get(@PathVariable long id) {	
		LOGGER.info("Request method: {} with id: {}", RequestMethod.GET, id);
		if (booksService.contains(id)) {
			return new ResponseEntity<Book>(booksService.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
}
