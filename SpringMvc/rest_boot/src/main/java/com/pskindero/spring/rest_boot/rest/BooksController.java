package com.pskindero.spring.rest_boot.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Book>> getAll() {	
		LOGGER.info("Request method: {}", RequestMethod.GET);
		return new ResponseEntity<List<Book>>(booksService.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", 
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> get(@PathVariable long id) {	
		LOGGER.info("Request method: {} with id: {}", RequestMethod.GET, id);
		if (booksService.contains(id)) {
			return new ResponseEntity<Book>(booksService.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST,
					produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE},
					consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> add(Book book) {
		LOGGER.info("Request method: {} with book object: {}", RequestMethod.POST, book);
		Book result = booksService.add(book);
		return new ResponseEntity<Book>(result, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE,
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> delete(@PathVariable long id) {	
		LOGGER.info("Request method: {} with id: {}", RequestMethod.DELETE, id);
		if (booksService.contains(id)) {
			return new ResponseEntity<Book>(booksService.delete(id), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
}
