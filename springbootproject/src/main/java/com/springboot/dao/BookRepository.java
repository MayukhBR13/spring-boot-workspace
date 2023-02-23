package com.springboot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Book;


@Repository
public interface BookRepository extends JpaRepository< Book,Integer> {
}
