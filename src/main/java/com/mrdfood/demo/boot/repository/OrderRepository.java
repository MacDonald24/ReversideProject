/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.repository;

import com.mrdfood.demo.boot.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author User
 */
public interface OrderRepository extends MongoRepository<Order, String>  {
    
}