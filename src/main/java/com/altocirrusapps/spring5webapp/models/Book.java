package com.altocirrusapps.spring5webapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String isbn;
	
	@OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
	private Publisher publisher;
	
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();

	public Book(String title, String isbn, Publisher publisher, Set<Author> authors) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}
	
	public Book(String title, String isbn, Publisher publisher) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	
	

	public Book() {
		//super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher pub) {
		
		if(pub == null) {
			if(this.publisher != null) {
				this.publisher.setBook(null);
			}
		} else {
			this.publisher.setBook(this);			//this is conflicting with publisher:88
		}
		
		this.publisher = pub;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", publisher=" + publisher + ", authors="
				+ authors + "]";
	}

	
	
	
	
	
	
}
