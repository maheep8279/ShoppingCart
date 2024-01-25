package com.caseStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caseStudy.model.BookStore;
import com.caseStudy.repository.BookStoreRepository;



@Service
public class BookStoreService {

	@Autowired
	BookStoreRepository bookStoreRepository;

	public List<BookStore> getAll(){
		
		return bookStoreRepository.findAll();
		
	}
	
	public BookStore getByBookId(int id) {
		return bookStoreRepository.findByBookId(id);
	}
	
	public BookStore getByBookName(String name) {
		return bookStoreRepository.findByBookName(name);
	}
	public List<BookStore> getBookRating(double rating) {
		return bookStoreRepository.findByRating(rating);
		
	}
	public List<BookStore> getBookPrice(double price){
		return bookStoreRepository.findByBookPrice(price);
	}
	public BookStore addBooks(BookStore bookStore) {
		return bookStoreRepository.save(bookStore);
	}
	public BookStore updateBook(BookStore bookStore) {
		BookStore bookStore2=bookStoreRepository.findByBookId(bookStore.getBookId());
		bookStore2.setBookName(bookStore.getBookName());
		bookStore2.setAuthor(bookStore.getAuthor());
		bookStore2.setRating(bookStore.getRating());
		bookStore2.setDescription(bookStore.getDescription());
		return bookStoreRepository.save(bookStore2);
	}
	
	public String deleteBook(int id) {
		BookStore bookStore=bookStoreRepository.findByBookId(id);
		bookStoreRepository.delete(bookStore);
		return "book deleted successfully";
	}
	

}

