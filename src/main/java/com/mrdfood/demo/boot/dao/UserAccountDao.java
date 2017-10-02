/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.dao;

import com.mrdfood.demo.boot.model.Person;
import com.mrdfood.demo.boot.model.UserAccount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class UserAccountDao {
    
    @Autowired
    MongoTemplate mt;
    
    public void createAccount(UserAccount account)
    {
        mt.insert(account);
    }
    
    public UserAccount getUserAccount(String username)
    {  
         Query query = new Query(Criteria.where("username").is(username));
        
          return mt.findOne(query, UserAccount.class,"account") ;
    }
    
     public List<UserAccount> getAllUserAccount()
    { 
        
          return mt.findAll(UserAccount.class) ;
    }
     
    public UserAccount accountUpdate(UserAccount account)
    {  
         Query queryPerson = new Query(Criteria.where("_id").is(account.getPersonId()));
   
         Person savedPerson = mt.findOne(queryPerson, Person.class,"person") ;
         
         savedPerson.setEmail(account.getUsername());
         savedPerson.setPassword(account.getPassword());
         
         mt.save(savedPerson);
                 
         Query queryAccount = new Query(Criteria.where("_id").is(account.getAccountId()));
         
   
        UserAccount savedUserAccount = mt.findOne(queryAccount, UserAccount.class,"account") ;
        
        savedUserAccount.setUsername(account.getUsername());
        savedUserAccount.setPassword(account.getPassword());
        
        mt.save(savedUserAccount);
        
        return savedUserAccount;
    }
}
