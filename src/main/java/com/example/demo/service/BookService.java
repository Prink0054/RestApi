package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Book;

@Component
public class BookService {

	private static List<Book> list = new ArrayList<Book>();
	
	
	static {
		
		list.add(new Book(45,"java cpmplete Reference","thjsd"));
		list.add(new Book(90,"python","naveen is author"));
		list.add(new Book(95,".net","rahul is author"));

	}
	
	
	public List<Book> listBooks(){
		
		return list;
	}
	
	
	public Book getBooksById(int id) {

		Book book = null;
		
		book = list.stream().filter(e->e.getId()==id).findFirst().get();
		
		return book; 
	}
	
	public Book addBook(Book book)
	
	{
		list.add(book);
		return book;
	}
	
	public Book deleteBook(int id) {

//list = l
		
		
		
	}
	
	
	
	
}
