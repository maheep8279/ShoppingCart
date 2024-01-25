package com.example.caseStudy.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.caseStudy.model.Address;
import com.example.caseStudy.model.BookStore;
import com.example.caseStudy.model.Cart;
import com.example.caseStudy.model.Order;
import com.example.caseStudy.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getByOrderId/{id}")
	public Order getByOrderId(@PathVariable("id") String id) {
		return orderService.getByOrderId(id);
	}

	@PostMapping("/addOrder/{cartId}/{name}")
	public Order addOrder(@PathVariable("cartId") int cartId, @PathVariable("name") String name,
			@RequestBody Address address) {

		Cart cart = restTemplate.getForObject("http://localhost:8082/getCartId/" + cartId, Cart.class);

		Order order = new Order();

		order.setName(name);
		LocalDate currentDate = LocalDate.now();
		order.setOrderDate(currentDate);
		List<BookStore> bookStores = cart.getBookStores();
		order.setBookStores(bookStores);
		double totalPrice = 0;
		for (BookStore bookStore : bookStores) {
			totalPrice = totalPrice + bookStore.getBookPrice();

		}
		order.setTotalPrice(totalPrice);
		order.setAddress(address);

		order.setOrderStatus("it will be delivered within 3 days");
		LocalDate dDate = LocalDate.now().plusDays(3);
		order.setDeliveryDate(dDate);

		Order order2 = orderService.addOrder(order);

		restTemplate.exchange("http://localhost:8085/updateAvaliableBooks/" + order2.getOrderId(), HttpMethod.PUT, null,
				String.class);

		return order2;

	}

	@PutMapping("/uOrder/{orderId}/{deliveryDate}")
	public Order uOrder(@PathVariable("orderId") String orderId, @PathVariable("deliveryDate") int deliveryDate) {

		Order order = orderService.getByOrderId(orderId);
		order.setOrderStatus("it will take  extra more days sorry for the delay");

		LocalDate dLocalDate = order.getDeliveryDate().plusDays(deliveryDate);

		order.setDeliveryDate(dLocalDate);

		return orderService.uOrder(order);
	}
}



