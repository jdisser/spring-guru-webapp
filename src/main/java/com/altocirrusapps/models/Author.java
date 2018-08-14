package com.altocirrusapps.models;

import java.util.Set;
import java.util.HashSet;

public class Author {
	
	private String firstName;
	private String lastName;
	

	private Set<Book> books = new HashSet<>();
	
	public void Author() {
		
	}
	public void Author(String last, String first) {
		this.lastName = last;
		this.firstName = first;
	}
	public void Author(String last, String first, Set<Book> books) {
		this.lastName = last;
		this.firstName = first;
		this.books = books;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
