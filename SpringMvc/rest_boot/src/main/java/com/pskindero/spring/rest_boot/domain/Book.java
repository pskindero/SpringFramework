package com.pskindero.spring.rest_boot.domain;

import com.pskindero.spring.rest_boot.api.Identifable;

public class Book implements Identifable{

	private static long idGen = 1l;
	private long id;
	private String title;
	private String author;
	private int year;
	
	public Book(String title, String author, int year) {
		this();
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	public Book() {
		super();
		id = idGen;
		idGen++;
	}

	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", year=");
		builder.append(year);
		builder.append("]");
		return builder.toString();
	}
}
