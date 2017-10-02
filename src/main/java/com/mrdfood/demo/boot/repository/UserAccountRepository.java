/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.repository;

import com.mrdfood.demo.boot.model.Person;
import com.mrdfood.demo.boot.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, String>  {
    
    
    @Query(value="{ 'username' : ?0 }", fields="{ 'username' : 1}")
    public UserAccount userAccount(String username);
    UserAccount save(UserAccount account);
    public Person getByEmail(String email); 
   
    
    
    
}
