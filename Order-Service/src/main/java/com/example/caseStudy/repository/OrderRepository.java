package com.example.caseStudy.repository;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.caseStudy.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {

	public Order findByOrderId(String orderId);

	public Order findByOrderDate(LocalDate orderDate);

	public Order findByTotalPrice(double totalPrice);

}
