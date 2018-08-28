package com.altocirrusapps.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.altocirrusapps.spring5webapp.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
}
