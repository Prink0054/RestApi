package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	//handler method
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookService.listBooks();	
	}
	
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		
		return this.bookService.getBooksById(id);
	}
	
	
	@PostMapping("//books")
	public Book addBook(@RequestBody Book book) {
		
		return this.bookService.addBook(book);
	}
	
	
	@DeleteMapping()
	public Book deleteBook() {
		
		//return 
	}
	
	
	
	
	
	
	
	
	

}
