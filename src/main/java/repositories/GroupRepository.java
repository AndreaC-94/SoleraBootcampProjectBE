package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import entitites.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, String>{

}
