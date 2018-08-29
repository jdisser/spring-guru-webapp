package com.altocirrusapps.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altocirrusapps.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	private AuthorRepository ar;

	public AuthorController(AuthorRepository ar) {
		//super();
		this.ar = ar;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", ar.findAll());
		
		return "authors";
	}

}
