/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.controller;

import com.mrdfood.demo.boot.Services.PaymentServiceImp;
import com.mrdfood.demo.boot.model.Payment;
import com.mrdfood.demo.boot.model.ValidationError;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
 @RequestMapping("/api/payment")
public class PaymentController {
    
    
    PaymentServiceImp paymentServiceImp;
    
    @Autowired
    MongoTemplate mongoOperation;
    
     @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Payment> save(@RequestBody @Valid Payment payment, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
		 mongoOperation.save(payment);
                
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
    
      @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    List<Payment> getAll() throws Exception {
    
	 List<Payment> payments = mongoOperation.findAll(Payment.class);
                
        return payments;
    }
    
}
