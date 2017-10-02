package com.mrdfood.demo.boot.dao;

import com.mrdfood.demo.boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {
	
	@Autowired
	MongoTemplate mt;

	public void createAccount(Person person)
	{
            mt.insert(person);
	}

        public Person getPersonByEmail(String email)
        {
           
            Query query = new Query();
            
            query.addCriteria(Criteria.where("email").is(email));
            
            Person person = mt.findOne(query, Person.class,"person");
           
            
                return person;
        }
        
        
        public Person editProfile(Person person)
        {
            Query query = new Query();
                query.addCriteria(Criteria.where("_id").is(person.getId()));
            Person editPerson = mt.findOne(query, Person.class, "person");
            
            editPerson.setFirstName(person.getFirstName());
            editPerson.setLastName(person.getLastName());
            editPerson.setMobileNumber(person.getMobileNumber());
            editPerson.setAlternateNumber(person.getAlternateNumber());
            editPerson.setGender(person.getGender());
            
            mt.save(editPerson);
                    
             return editPerson;
        }
        
        
}
