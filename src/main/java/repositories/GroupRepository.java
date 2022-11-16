package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import entities.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, String>{

}
