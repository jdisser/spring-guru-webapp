package com.altocirrusapps.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.altocirrusapps.spring5webapp.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
