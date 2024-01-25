package com.example.caseStudy.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Document(collection = "books")
public class BookStore {
	@Id
	public int bookId;
	public String bookName;
	// public String author;
	// public double rating;
	// public String description;
	public double bookPrice;
	public int quantity;

}

