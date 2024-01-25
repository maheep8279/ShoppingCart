package com.example.caseStudy.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caseStudy.model.Order;
import com.example.caseStudy.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public List<Order> getOrdersList() {

		return orderRepository.findAll();

	}

	public Order getByOrderId(String orderId) {
		return orderRepository.findByOrderId(orderId);
	}

	public Order getByOrderDate(LocalDate orderDate) {
		return orderRepository.findByOrderDate(orderDate);
	}

	public Order getByTotalPrice(double totalPrice) {
		return orderRepository.findByTotalPrice(totalPrice);
	}

	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order uOrder(Order order) {
		return orderRepository.save(order);
	}

	public String deleteOrder(String orderId) {
		Order order = orderRepository.findByOrderId(orderId);
		orderRepository.delete(order);
		return "delete exiting order";
	}

}
