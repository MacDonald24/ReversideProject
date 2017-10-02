/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.controller;

import com.mrdfood.demo.boot.Services.OrderServiceImpl;
import com.mrdfood.demo.boot.model.Order;
import com.mrdfood.demo.boot.model.ValidationError;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
    
    @Autowired
    OrderServiceImpl orderServiceImpl;
    
    @Autowired
    MongoTemplate mongoOperations;
    
    @RequestMapping(value="/all" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getOrders() {
       return orderServiceImpl.findAll();
    }
    
    @RequestMapping(value="/customer/{personId}" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getCustomerOrders(@PathVariable @Valid String personId) {
         Query query = Query.query(Criteria.where("personId").is(personId));
        
       List<Order> orders = mongoOperations.find(query, Order.class);
       
       return orders;
    }
    
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Order> save(@RequestBody @Valid Order order, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
        
		Order savedOrder = orderServiceImpl.save(order);

        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
    }
    
}
