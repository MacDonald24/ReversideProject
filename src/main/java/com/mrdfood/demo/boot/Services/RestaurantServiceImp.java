/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Category;
import com.mrdfood.demo.boot.model.Restaurant;
import com.mrdfood.demo.boot.repository.RestaurantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class RestaurantServiceImp implements RestaurantService {
    
    @Autowired
    private final RestaurantRepository restaurantRepository;
    @Autowired
    private final MongoTemplate mongoOperationa;
    
    @Autowired
    RestaurantServiceImp(RestaurantRepository restaurantRepository,MongoTemplate mongoOperationa)
    {
        this.restaurantRepository = restaurantRepository;
        this.mongoOperationa = mongoOperationa;
    }
    @Override
    public List<Restaurant> findAll() {
        
        List<Restaurant> restuarants = restaurantRepository.findAll();
        return restuarants;
    }
    @Override
    public Restaurant create(Restaurant Restaurant) {
        
        Restaurant savedRestaurant = restaurantRepository.save(Restaurant);
        return savedRestaurant;
    }

    @Override
    public Restaurant findById(String id) {
      Restaurant savedRestaurant =   restaurantRepository.findOne(id);
       return savedRestaurant;
    }

    @Override
    public Restaurant delete(String id) {
        Restaurant savedRestaurant =   restaurantRepository.findOne(id);
        restaurantRepository.delete(savedRestaurant);
       return savedRestaurant;
       
    }

    @Override
    public Restaurant findByAccountId(String id) {
  
        Restaurant savedRestaurant = restaurantRepository.findByAccountId(id);
  
        return savedRestaurant;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
       Restaurant savedRestaurant = findById(restaurant.getRestaurantId());
       savedRestaurant.setRestaurantId(restaurant.getRestaurantId());
       savedRestaurant.setName(restaurant.getName());
       savedRestaurant.setImage(restaurant.getImage());
       savedRestaurant.setCategoryId(restaurant.getCategoryId());
       savedRestaurant.setAddress(restaurant.getAddress());
       savedRestaurant.setAccountId(restaurant.getAccountId());
        mongoOperationa.save(savedRestaurant);
        return savedRestaurant;
    }

    @Override
    public Restaurant addCateogory(String accountId, Category category) {
        
        Restaurant savedRestaurant = restaurantRepository.findByAccountId(accountId);
        
        savedRestaurant.addCategories(category);
        
        mongoOperationa.save(category);
        mongoOperationa.save(savedRestaurant);
        
        return savedRestaurant;
    }
    
    
}
