package com.springboot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.springboot.model.Book;

@NoRepositoryBean
@Repository
public class BookRepository implements CrudRepository< Book,Integer> {
	public Book findById(Integer id);
	
}
