package com.caseStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caseStudy.model.Cart;
import com.caseStudy.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	public List<Cart> getAll() {
		return cartRepository.findAll();
	}

	public Cart getByCartId(int id) {
		return cartRepository.findByCartId(id);
	}

	public Cart addBookIntoCart(Cart cart) {
		return cartRepository.save(cart);

	}

	public Cart updateCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public String deleteCart(int id) {
		Cart cart = cartRepository.findByCartId(id);
		cartRepository.delete(cart);
		return "cart deleted successfully";
	}
}





