/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Person;
import java.util.List;

/**
 *
 * @author User
 */
public interface PersonService {
 
    Person create(Person person);
 
    Person delete(String id);
 
    List<Person> findAll();
 
    Person findById(String id);
 
    Person update(Person person);
    
    Person findByEmail(String email);
    
    Person findByFirstName(String firstName);
    
    
}
