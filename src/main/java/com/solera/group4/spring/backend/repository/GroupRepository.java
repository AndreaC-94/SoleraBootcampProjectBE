package com.solera.group4.spring.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.solera.group4.spring.backend.entitites.Group;

public interface GroupRepository extends MongoRepository<Group, String>{
	Group findByName(String name);
	
	public long count();
	
}
