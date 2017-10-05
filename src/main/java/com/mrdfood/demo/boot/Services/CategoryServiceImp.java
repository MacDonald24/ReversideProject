/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Category;
import com.mrdfood.demo.boot.model.Item;
import com.mrdfood.demo.boot.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    MongoTemplate mongoOperation;
    
    @Autowired
    CategoryServiceImp(CategoryRepository categoryRepository,MongoTemplate mongoOperation)
    {
        this.categoryRepository = categoryRepository;
        this.mongoOperation = mongoOperation;
    }
    @Override
    public Category create(Category category) {
       
        Category savedCategory = categoryRepository.save(category);
        
        return savedCategory;
        
    }

    @Override
    public Category update(Category category) {
         Category savedCategory = categoryRepository.findOne(category.getCategoryId());
      
      return savedCategory;
        
    }

    @Override
    public Category delete(String id) {
         Category savedCategory = categoryRepository.findOne(id);
      
      return savedCategory;
    }

    @Override
    public Category findById(String id) {
        
      Category savedCategory = categoryRepository.findOne(id);
      
      return savedCategory;
    }

    @Override
    public Category findByName(String name) {
       
        Category savedCategory = categoryRepository.findByName(name);
        
        return savedCategory;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category addItem(String categoryId,Item item) {
        
        Category savedCategory = findById(categoryId);
        savedCategory.addCategories(item);
        mongoOperation.save(savedCategory);
        return savedCategory;
    }
    
}
