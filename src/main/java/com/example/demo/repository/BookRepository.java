 package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Book;

public interface BookRepository  extends CrudRepository<Book, Integer>{

	public Book findById(int id);
	
}
