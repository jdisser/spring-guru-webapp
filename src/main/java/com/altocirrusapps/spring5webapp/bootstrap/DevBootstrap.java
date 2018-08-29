package com.altocirrusapps.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.altocirrusapps.spring5webapp.models.Author;
import com.altocirrusapps.spring5webapp.models.Book;
import com.altocirrusapps.spring5webapp.models.Publisher;
import com.altocirrusapps.spring5webapp.repositories.AuthorRepository;
import com.altocirrusapps.spring5webapp.repositories.BookRepository;
import com.altocirrusapps.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository ar;
	private BookRepository br;
	private PublisherRepository pr;
	
		
	public DevBootstrap(AuthorRepository ar, BookRepository br, PublisherRepository pr) {
		//super();
		this.ar = ar;
		this.br = br;
		this.pr = pr;
	}

	private void initData() {
		
		//Harper
		Publisher harper = new Publisher("Harper Collins","123 Main Street","Anytown","CO","80000");
		//pr.save(harper);
		
		//Worx
		Publisher worx = new Publisher("Worx","124 Side Street","Somewhere","NJ","20000");
		//pr.save(worx);
		
		
		
		//eric
		Author eric = new Author("Evans", "Eric");
		Book ddd = new Book("Domain Driven Design", "1234", harper);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ar.save(eric);
		br.save(ddd);
		harper.setBook(ddd);
		pr.save(harper);
		
		
		
		//Rod
		Author rod = new Author("Johnson", "Rod");
		Book noEBJ = new Book("J2EE Development without EJB","2344",worx);
		rod.getBooks().add(noEBJ);
		noEBJ.getAuthors().add(rod);		

		ar.save(rod);
		br.save(noEBJ);
		worx.setBook(noEBJ);
		pr.save(worx);
		

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
		
	}
}
