package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.model.Book;

@Service
public class BookService {
	private static List<Book> books = new ArrayList<>();
	static {
		books.add(new Book(12300,"book1","xcv"));
		books.add(new Book(12301,"book2","xdf"));
		books.add(new Book(12302,"book3","xer"));
	}
	public List<Book> getAllBooks(){
		System.out.println(books);
		return books;
	}
	
	public Book getBookById(int id) {
		return books.stream().filter(e->e.getId()==id).findFirst().get();
	}
}
