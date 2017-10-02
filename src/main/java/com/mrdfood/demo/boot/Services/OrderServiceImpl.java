/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Order;
import com.mrdfood.demo.boot.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    MongoTemplate mongoOperations;
    
    @Override
    public Order save(Order order) {
      
        orderRepository.save(order);
       return order;
    };

    @Override
    public List<Order> findAll() {
        
       List<Order> orders = orderRepository.findAll();
       return orders;
    }

    @Override
    public List<Order> findByPerson(String personId) {
        Query query = Query.query(Criteria.where("person._id").is(personId));
        
       List<Order> orders = mongoOperations.find(query, Order.class);
       
       return orders;
    }
    
}
