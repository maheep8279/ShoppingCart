package com.caseStudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.caseStudy.model.BookStore;
@Repository
public interface BookStoreRepository extends MongoRepository<BookStore, Integer>{
	
	public BookStore findByBookId(int id);
	
	public BookStore findByBookName(String name);
	
	
	public List<BookStore> findByRating(double rating);
	
	public List<BookStore> findByBookPrice(double price);
}
