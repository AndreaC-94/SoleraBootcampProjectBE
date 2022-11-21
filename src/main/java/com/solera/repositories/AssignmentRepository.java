package com.solera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.solera.entities.Assignment;

@Repository
public interface AssignmentRepository extends MongoRepository<Assignment, Integer>{

    boolean existsById(int id);
    boolean existsByName(String name);
    Assignment findByName(String name);
    boolean deleteByName(String name);
}
