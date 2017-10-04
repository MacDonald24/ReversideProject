package com.mrdfood.demo.boot.Services;


import com.mrdfood.demo.boot.model.Person;
import com.mrdfood.demo.boot.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    private final PersonRepository personRepository;
    
    @Autowired
    private final MongoTemplate mongoOperation;
    
    @Autowired
    PersonServiceImp(PersonRepository repository,MongoTemplate mongoOperation) {
        this.personRepository = repository;
        this.mongoOperation = mongoOperation;
    }
    
    @Override
    public Person create(Person person) {
       
      Person personSaved =  personRepository.save(person);
      
      return personSaved;
    }

    @Override
    public Person delete(String id) {
        
        Person personSaved =  personRepository.findOne(id);
        if(personSaved != null)
        {
            mongoOperation.remove(personSaved);
        }
        return personSaved;
    }

    @Override
    public List<Person> findAll() {
    
        List<Person> people = personRepository.findAll();
        
            return people;
    }

    @Override
    public Person findById(String id) {
         Person personSaved =  personRepository.findOne(id);
         return personSaved;
    }

    @Override
    public Person update(Person person) {
        
        Query query = new Query();
                query.addCriteria(Criteria.where("_id").is(person.getId()));
            Person editPerson = mongoOperation.findOne(query, Person.class, "person");
            
            editPerson.setFirstName(person.getFirstName());
            editPerson.setLastName(person.getLastName());
            editPerson.setMobileNumber(person.getMobileNumber());
            editPerson.setAlternateNumber(person.getAlternateNumber());
            editPerson.setGender(person.getGender());
            
            mongoOperation.save(editPerson);
                    
             return editPerson;
    }

    @Override
    public Person findByEmail(String email) {
        
       Person savedPerson = personRepository.findByEmail(email);
       
       return savedPerson;
    }

    @Override
    public Person findByFirstName(String firstName) {
        
       Person savedPerson = personRepository.findByFirstName(firstName);
        
       return savedPerson;
    }

    
    
}
