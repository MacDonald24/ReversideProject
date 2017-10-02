/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.dao;

import com.mrdfood.demo.boot.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


/**
 *
 * @author User
 */
@Component
public class RestaurantDao {
        
        @Autowired
	MongoTemplate mt;

	public void createRestuarant(Restaurant restaurant )
	{
		mt.insert(restaurant);
	}
        
        public Restaurant getByUserAccId(String accountId)
        {
            Query query = new Query(Criteria.where("accountId").is(accountId));
            Restaurant restuarant = mt.findOne(query, Restaurant.class,"restaurant");
            return restuarant;
        }
}
