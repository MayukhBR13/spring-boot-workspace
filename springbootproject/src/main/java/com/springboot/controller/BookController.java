package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Book;
import com.springboot.service.BookService;


@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		//Book book=new Book(12500,"Java Spring boot","ABC");
		List<Book> list= bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}


	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book>  getBookById(@PathVariable("bookId") int id) {
		Book book= this.bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
		
	}

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		System.out.println(book);
		//Book b= this.bookService.addBook(book);
		Book b=null;
		try {
			b=this.bookService.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Void> updateBook(@RequestBody Book book,@PathVariable int id) {
//		System.out.println(book);
//		this.bookService.updateBook(book,id);
//		return b;
		try {
			this.bookService.updateBook(book,id);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
		}
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int id) {
//		return this.bookService.deleteBook(id);
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
		}
	
	}
	
}
