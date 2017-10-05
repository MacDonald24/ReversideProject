/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Category;
import com.mrdfood.demo.boot.model.Restaurant;
import java.util.List;

/**
 *
 * @author User
 */
public interface RestaurantService {
 
    public List<Restaurant> findAll();
    public Restaurant create(Restaurant Restaurant);
    public Restaurant findById(String id);
    public Restaurant delete(String id);
    public Restaurant findByAccountId(String id);
    public Restaurant update(Restaurant restaurant);
    public Restaurant addCateogory(String accountId,Category category);
    
}
