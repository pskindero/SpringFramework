package com.pskindero.spring.rest_boot.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.pskindero.spring.rest_boot.dbs.StubDb;
import com.pskindero.spring.rest_boot.domain.Book;

@Configuration
public class DbsConfiguration {

	@Bean
	@Primary
	@Profile("production")
	public StubDb<Book> booksDb() {
		return new StubDb<Book>();
	}
	
	@Bean(name = "testBooksDb")
	@Profile("test")
	public StubDb<Book> testBooksDb() {
		StubDb<Book> db = new StubDb<Book>();
		db.add(new Book("Ogniem i mieczem", "Henryk Sienkiewicz", 1900));
		db.add(new Book("Lalka", "Boleslaw Prus", 1890));
		return db;
	}
}
