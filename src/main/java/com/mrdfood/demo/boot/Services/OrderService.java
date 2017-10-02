/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Order;
import java.util.List;

/**
 *
 * @author User
 */
public interface OrderService {
    
    public Order save(Order order);
    public List<Order> findAll();
    public List<Order> findByPerson(String personId);
}
