package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Book;
import com.example.demo.repository.BookRepository;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	
	
	
	

//	private static List<Book> list = new ArrayList<Book>();
	
	
//	static {
//		
//		list.add(new Book(45,"java cpmplete Reference","thjsd"));
//		list.add(new Book(90,"python","naveen is author"));
//		list.add(new Book(95,".net","rahul is author"));
//
//	}
	
	
	public List<Book> listBooks(){
		
		//return list;
		
		
		
	List<Book> list = 	 (List<Book>) this.bookRepository.findAll();
	return list;
	
	}
	
	
	public Book getBooksById(int id) {

		//Book book = null;
		
		//book = list.stream().filter(e->e.getId()==id).findFirst().get();
		
	Book book =	this.bookRepository.findById(id);
		
		return book; 
	}
	
	public Book addBook(Book book)
	
	{
		//list.add(book);
		
	Book result = 	this.bookRepository.save(book);
		
		return result;
	}
	
	public void deleteBook(int id) {

//list = l


		bookRepository.deleteById(id);
	}
	
	
	public void updateBook(Book book, int bookId) {
		
		
	//	book.setId(bookId);
	//	book.setAuthor("dksaljdkas");
	
Book book2 =		bookRepository.findById(bookId);

//book2.setAuthor("naveen");
		
		book2.setAuthor(book.getAuthor());
		
		bookRepository.save(book2);
	}
	
	
	
	
}
