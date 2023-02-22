package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Book;
import com.springboot.service.BookService;


@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/books")
	public List<Book> getBooks() {
		//Book book=new Book(12500,"Java Spring boot","ABC");
		return bookService.getAllBooks();
	}
}
