package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	//Response Enttity is child class of HttpStatus entity 
	
	//handler method
	@GetMapping("/books")
	public   ResponseEntity<List<Book>> getBooks() {
	List<Book>list = 	 this.bookService.listBooks();	
	
	if(list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	return ResponseEntity.of(Optional.of(list));
	//return ResponseEntity.status(HttpStatus.CREATED)
	
	//return ResponseEntity.status(HttpStatus.CREATED).Optiona
	}
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		
		
		
		
		Book book =  this.bookService.getBooksById(id);
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
		
		
	}
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		
		return this.bookService.addBook(book);
	}
	
	
	@DeleteMapping("/deletebook/{id}")
	public void deleteBook(@PathVariable("id") int id ) {
		
		 this.bookService.deleteBook(id);
			}
	
	
	@PutMapping("/update/{id}")
	public void updateBook(@PathVariable("id") int id,@RequestBody Book book) {
		
		this.bookService.updateBook(book,id);
	}
	
	
	
	
	
	

}
