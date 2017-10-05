/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Category;
import com.mrdfood.demo.boot.model.Item;
import java.util.List;

/**
 *
 * @author User
 */
public interface CategoryService {
    
    public Category create(Category category);
    public Category update(Category category);
    public Category delete(String id);
    public Category findById(String id);
    public Category findByName(String name);
    public List<Category> findAll();
    public Category addItem(String categoryId,Item item);
    
}
