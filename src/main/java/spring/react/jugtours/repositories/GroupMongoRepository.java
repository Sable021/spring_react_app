package spring.react.jugtours.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.react.jugtours.model.Group;

public interface GroupMongoRepository extends MongoRepository<Group, String> {
    Group findByName(String Name);
}
