package com.caseStudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "books")
public class BookStore {
	@Id
	public int bookId;
	public String bookName;
	public String author;
	public double rating;
	public String description;
	public double bookPrice; 

}
