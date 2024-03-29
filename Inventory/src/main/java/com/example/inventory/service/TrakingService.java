package com.example.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.model.Traking;
import com.example.inventory.repository.TrakingRepository;

@Service
public class TrakingService {

	@Autowired
	TrakingRepository trakingRepository;

	public Traking createBooksAvaliability(Traking traking) {

		return trakingRepository.save(traking);

	}

	public Traking getByBookId(int id) {
		return trakingRepository.findByBookId(id);
	}

	public Traking UpdateBooks(Traking traking) {
		return trakingRepository.save(traking);
	}

	public Traking getByBooksAvaliable(int avaliableBooks) {

		return trakingRepository.findBybooksAvaliability(avaliableBooks);
	}

}
