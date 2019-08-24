package com.felipebueno.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipebueno.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
