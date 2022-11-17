package com.solera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.solera.entities.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, Integer>{
    public Group findByName(String name);
    public boolean existsByName(String name);
}
