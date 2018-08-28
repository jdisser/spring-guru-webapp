package com.altocirrusapps.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.altocirrusapps.spring5webapp.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
