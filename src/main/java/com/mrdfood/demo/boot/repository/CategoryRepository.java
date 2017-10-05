/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.repository;

import com.mrdfood.demo.boot.model.Category;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    
    public Category save(Category category);
    public  Category findByName(String categoryName);
}
