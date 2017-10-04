/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Person;
import com.mrdfood.demo.boot.model.UserAccount;
import com.mrdfood.demo.boot.repository.PersonRepository;
import com.mrdfood.demo.boot.repository.UserAccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class UserAccountServiceImp implements UserAccountService {
    
    @Autowired
    private final PersonRepository personRepository;
    @Autowired
    private final UserAccountRepository userAccountRepository;
    @Autowired
    private final MongoTemplate mongoOperation;
    
    @Autowired
    UserAccountServiceImp(UserAccountRepository userAccountRepository,MongoTemplate mongoOperation,PersonRepository personRepository)
    {
        this.personRepository = personRepository;
        this.userAccountRepository = userAccountRepository;
        this.mongoOperation = mongoOperation;   
    }
    
    @Override
    public UserAccount create(Person person) {
        Person savedUser = personRepository.save(person);
                
                UserAccount newUserAccount = new UserAccount();
                if(savedUser != null)
                {
                    
                    Person user = personRepository.findOne(savedUser.getId());
                    newUserAccount.setPersonId(user.getId());
                    newUserAccount.setUsername(user.getEmail());
                    newUserAccount.setPassword(user.getPassword());
                    newUserAccount.setRole("Customer");
                }
        UserAccount savedUserAccount = userAccountRepository.save(newUserAccount);
        
        return savedUserAccount;
    }

    @Override
    public List<UserAccount> findAll() {
        List<UserAccount> userAccounts = userAccountRepository.findAll();
        
        return userAccounts;
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
         Query queryPerson = new Query(Criteria.where("_id").is(userAccount.getPersonId()));
   
         Person savedPerson = mongoOperation.findOne(queryPerson, Person.class,"person") ;
         
         savedPerson.setEmail(userAccount.getUsername());
         savedPerson.setPassword(userAccount.getPassword());
         
         mongoOperation.save(savedPerson);
                 
         Query queryAccount = new Query(Criteria.where("_id").is(userAccount.getAccountId()));
         
   
        UserAccount savedUserAccount =  mongoOperation.findOne(queryAccount, UserAccount.class,"account") ;
        
        savedUserAccount.setUsername(userAccount.getUsername());
        savedUserAccount.setPassword(userAccount.getPassword());
        
        mongoOperation.save(savedUserAccount);
        
        return savedUserAccount;
    }

    @Override
    public UserAccount delete(String id) {
        UserAccount savedUserAccount = findById(id);
        
        if(savedUserAccount != null)
        {
            Person savedPerson = personRepository.findOne(savedUserAccount.getPersonId());
            mongoOperation.remove(savedPerson);
            mongoOperation.remove(savedUserAccount);
        }
        return savedUserAccount;  
    }

    @Override
    public UserAccount findByUsernameAndPassword(String username, String password) {
            /*Query query = new Query(Criteria.where("username").is(loginDto.username).and("password").is(loginDto.password) );
        
             UserAccount userAccount = mongoOperation.findOne(query, UserAccount.class,"account") ;*/
            
      UserAccount savedUserAccount =  userAccountRepository.findByUsernameAndPassword(username, password);
      return savedUserAccount;
    }

    @Override
    public UserAccount findById(String Id) {
        UserAccount savedUserAccount = userAccountRepository.findOne(Id);
        return savedUserAccount;
    }

    @Override
    public UserAccount createPartner(Person person) {
             Person savedUser = personRepository.save(person);
                
                UserAccount newUserAccount = new UserAccount();
                if(savedUser != null)
                {
                    
                    Person user = personRepository.findOne(savedUser.getId());
                    newUserAccount.setPersonId(user.getId());
                    newUserAccount.setUsername(user.getEmail());
                    newUserAccount.setPassword(user.getPassword());
                    newUserAccount.setRole("Partner");
                }
        UserAccount savedUserAccount = userAccountRepository.save(newUserAccount);
        
        return savedUserAccount;
    }

    @Override
    public UserAccount findByUsername(String username) {
    
           UserAccount savedUserAccount = userAccountRepository.findByUsername(username);
           
           return savedUserAccount;
     
    }

    @Override
    public UserAccount createDriver(Person person) {
         Person savedUser = personRepository.save(person);
                
                UserAccount newUserAccount = new UserAccount();
                if(savedUser != null)
                {
                    
                    Person user = personRepository.findOne(savedUser.getId());
                    newUserAccount.setPersonId(user.getId());
                    newUserAccount.setUsername(user.getEmail());
                    newUserAccount.setPassword(user.getPassword());
                    newUserAccount.setRole("Driver");
                }
        UserAccount savedUserAccount = userAccountRepository.save(newUserAccount);
        
        return savedUserAccount;
    }
    
}
