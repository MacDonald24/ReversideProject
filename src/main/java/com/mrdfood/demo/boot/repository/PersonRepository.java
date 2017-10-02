package com.mrdfood.demo.boot.repository;

import com.mrdfood.demo.boot.model.Person;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface PersonRepository extends MongoRepository<Person, String>{ 
	 
	    public List<Person> findAll();
            public Person save(Person person);
          
}
