package com.altocirrusapps.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.altocirrusapps.spring5webapp.models.Author;
import com.altocirrusapps.spring5webapp.models.Book;
import com.altocirrusapps.spring5webapp.repositories.AuthorRepository;
import com.altocirrusapps.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository ar;
	private BookRepository br;
	
		
	public DevBootstrap(AuthorRepository ar, BookRepository br) {
		//super();
		this.ar = ar;
		this.br = br;
	}

	private void initData() {
			
		//eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ar.save(eric);
		br.save(ddd);
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEBJ = new Book("J2EE Development without EJB","2344","Worx");
		rod.getBooks().add(noEBJ);
		noEBJ.getAuthors().add(rod);
		
		ar.save(rod);
		br.save(noEBJ);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
		
	}
}
