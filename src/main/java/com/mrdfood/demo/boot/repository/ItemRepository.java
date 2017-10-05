/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.repository;

import com.mrdfood.demo.boot.model.Item;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author User
 */
public interface ItemRepository extends MongoRepository<Item, String> {

    
    public Item findOne(String id);
    //public List<String> findByCategoryId(String categoryId);
    public List<Item> findByCategoryId(String categoryId);
    public Item save(Item item);
    
}
