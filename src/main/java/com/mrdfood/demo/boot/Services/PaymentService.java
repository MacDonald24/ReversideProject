/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Payment;

/**
 *
 * @author User
 */
public interface PaymentService {
    
    public Payment save(Payment payment);
    
}
