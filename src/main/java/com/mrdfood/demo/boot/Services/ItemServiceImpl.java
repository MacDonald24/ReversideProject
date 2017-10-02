/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Item;
import com.mrdfood.demo.boot.repository.ShoppingCartRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    
    @Override
    public List<Item> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public Item find(String itemId) {
       return shoppingCartRepository.findOne(itemId);
    }
    
}
