/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.dao;

import com.mrdfood.demo.boot.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class CategoryDao {
    
    @Autowired
    MongoTemplate mt;
    
    public Category insertCategory(Category category)
    {
        if(category != null)
        {
             mt.insert(category);
        }
       
        return category;
    }
}
