package com.altocirrusapps.spring5webapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String address1;
	private String city;
	private String state;
	private String zip;
	
	@OneToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;
	
	
	public Publisher() {
		//super();
	}

	public Publisher(String name, String address1, String city, String state, String zip, Book book) {
		//super();
		//this.id = id;
		this.name = name;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.book = book;
		
	}
	
	public Publisher(String name, String address1, String city, String state, String zip) {
		//super();
		//this.id = id;
		this.name = name;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.book = null;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public long getId() {
		return id;
	}
	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		/*
		if(book == null) {							//if the book is being nulled
			if(this.book != null) {						//check if there is one already
				this.book.setPublisher(null);			//and if so set its publisher to null
			}
		} else {
			book.setPublisher(this);				//otherwise set the new book's publisher to this  CONFLICT WITH book:72
		}
		*/
		this.book = book;							//and set the book
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		
		
		if (id != other.id)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address1=" + address1 + ", city=" + city + ", state="
				+ state + ", zip=" + zip + "]";
	}
	
	
	
	

}
