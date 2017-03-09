package com.pskindero.spring.rest_boot.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pskindero.spring.rest_boot.domain.Book;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

	public BooksController() {
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Book> getAll() {
		
		return null;
	}
}
