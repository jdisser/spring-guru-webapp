package com.altocirrusapps.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altocirrusapps.spring5webapp.repositories.BookRepository;

@Controller

public class BookController {
	
	
	private BookRepository br;
		
	public BookController(BookRepository br) {
		//super();
		this.br = br;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", br.findAll());
		
		return "books";
		
	}

}
