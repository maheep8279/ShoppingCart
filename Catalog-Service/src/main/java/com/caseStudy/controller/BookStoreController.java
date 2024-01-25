package com.caseStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caseStudy.model.BookStore;
import com.caseStudy.service.BookStoreService;

@RestController
public class BookStoreController {
	
	@Autowired
	BookStoreService bookStoreService;

	@GetMapping("/getAllBooks")
	public List<BookStore> getAllBooks(){
		return bookStoreService.getAll();	
		}
	
	@GetMapping("/getBookById/{id}")
	public BookStore getBookById(@PathVariable("id") int id){
		return bookStoreService.getByBookId(id);
		
	}
	@GetMapping("/getBookName/{name}")
	public BookStore getBookName(@PathVariable("name")  String name) {
		return bookStoreService.getByBookName(name);
	}
	@GetMapping("/getBookByRating/{rating}")
	public List<BookStore> getBookByRating(@PathVariable("rating") double rating){
		return bookStoreService.getBookRating(rating);
	}
	@GetMapping("/getBookByPrice/{price}")
	public List<BookStore> getBookByPrice(@PathVariable("price")double price){
		return bookStoreService.getBookPrice(price);
	}
	@PostMapping("/addBook")
	public BookStore addBook(@RequestBody BookStore book) {

		return   bookStoreService.addBooks(book);
	}
	
	@PutMapping("/updateBook")
	
	public BookStore updateBook(@RequestBody BookStore bookStore) {
		return bookStoreService.updateBook(bookStore);
	}
	@DeleteMapping("/removeBook/{id}")
	
	public String removeBook(@PathVariable("id")int id ) {
		return bookStoreService.deleteBook(id);
	}



}


