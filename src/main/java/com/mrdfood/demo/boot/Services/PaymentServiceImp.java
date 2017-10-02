/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Payment;
import com.mrdfood.demo.boot.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service("paymentService")
@Transactional
public class PaymentServiceImp implements PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    MongoTemplate mongoOperations;
    @Override
    public Payment save(Payment payment) {
      paymentRepository.save(payment);
       return payment;
    }

  
    
}
