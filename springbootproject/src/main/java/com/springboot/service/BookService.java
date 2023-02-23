package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.BookRepository;
import com.springboot.model.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	
	
	private static List<Book> books = new ArrayList<>();
	static {
		books.add(new Book(12300,"book1","xcv"));
		books.add(new Book(12301,"book2","xdf"));
		books.add(new Book(12302,"book3","xer"));
	}
	public List<Book> getAllBooks(){
//		System.out.println(books);
//		return books;
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	public Book getBookById(int id) {
//		return books.stream().filter(e->e.getId()==id).findFirst().get();
		Book book=null;
		try {
			book=(Book)this.bookRepository.findById(id).get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	
	}

	//post
	public Book addBook(Book bk) {
//		 books.add(bk);
		Book res=bookRepository.save(bk);
//		 return bk;
		return res;
	}
	//put
	public void updateBook(Book bk,int  id) {
//		 books.forEach(e->{
//			 if(e.getId()==bk.getId()) {
//				 e.setAuthor(bk.getAuthor());
//				 e.setTitle(bk.getTitle());
//			 }
//		 });
		bk.setId(id);
		bookRepository.save(bk);
	}
	
	public void deleteBook(int id) {
//		return books.removeIf(e->e.getId()==id);
		this.bookRepository.deleteById(id);
	}
}
