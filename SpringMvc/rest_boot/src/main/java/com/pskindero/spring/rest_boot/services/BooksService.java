package com.pskindero.spring.rest_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pskindero.spring.rest_boot.dbs.StubDb;
import com.pskindero.spring.rest_boot.domain.Book;

@Service
public class BooksService {

	@Autowired
	private StubDb<Book> db;
	
	public BooksService() {
	}
	
	public Book get(long id) {
		return db.get(id);
	}
	
	public List<Book> getAll() {
		return db.getAll();
	}
	
	public boolean contains(long id) {
		return db.contains(id);
	}
	
	public Book add(Book b) {
		return db.add(b);
	}
	
	public Book delete(long id) {
		return db.remove(id);
	}
}
