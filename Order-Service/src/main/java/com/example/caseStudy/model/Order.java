package com.example.caseStudy.model;

import java.time.LocalDate;
import java.util.List;

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
@Document(collection = "orders")
public class Order {
	@Id
	public String orderId;
	public String name;
	public LocalDate orderDate;
	public double totalPrice;

	public List<BookStore> bookStores;
	public String orderStatus;
	public LocalDate deliveryDate;
	public Address address;

}
