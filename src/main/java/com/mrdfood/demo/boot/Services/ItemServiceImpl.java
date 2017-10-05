/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Item;
import com.mrdfood.demo.boot.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private final ItemRepository itemRepository;
    @Autowired
    private final MongoTemplate mongoOperation;
    
    @Autowired
    ItemServiceImpl(ItemRepository itemRepository , MongoTemplate mongoOperation)
    {
        this.itemRepository = itemRepository;
        this.mongoOperation = mongoOperation;
    }
    @Override
    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    @Override
    public Item create(Item item) {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }

    @Override
    public Item delete(String id) {
        
         Item savedItem = itemRepository.findOne(id);
         itemRepository.delete(savedItem);
       return savedItem;
    }

    @Override
    public Item update(Item item) {
      Item savedItem = itemRepository.findOne(item.getItemId());
      
     savedItem.setCategoryId(item.getCategoryId());
     savedItem.setItemId(item.getItemId());
     savedItem.setName(item.getName());
     savedItem.setPrice(item.getPrice());
     savedItem.setShortDescription(item.getShortDescription());
     
        mongoOperation.save(savedItem);
     return savedItem;
    }


    @Override
    public Item findById(String id) {
       Item savedItem = itemRepository.findOne(id);
       return savedItem;
    }

    @Override
    public List<Item> findItems(String categoryId) {
        List<Item> savedItems  = itemRepository.findByCategoryId(categoryId);
       
        return savedItems;
    }

    @Override
    public List<String> findByCategoryId(String categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
