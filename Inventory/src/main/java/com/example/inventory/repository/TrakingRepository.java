package com.example.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.inventory.model.Traking;

public interface TrakingRepository extends MongoRepository<Traking, Integer> {

	public Traking findByBookId(int id);

	public Traking findBybooksAvaliability(int avaliability);

}
