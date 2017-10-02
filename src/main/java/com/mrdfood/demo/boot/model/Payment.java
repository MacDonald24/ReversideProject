/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author User
 */
@Document
public class Payment {
    
    @Id
    private String paymentId;
    private String customerName;
    private String customSurname;
    private String customerId;
    private String orderId;
    private String transactionType;
    @Field
    private String nameOnCard;
    @Field
    private int cardNumber;
    @Field
    private String expireDate;
    @Field
    private int securityCode;

    public Payment() {
    }

    public Payment(String paymentId, String customerName, String customSurname, String customerId, String orderId, String transactionType) {
        this.paymentId = paymentId;
        this.customerName = customerName;
        this.customSurname = customSurname;
        this.customerId = customerId;
        this.orderId = orderId;
        this.transactionType = transactionType;
    }
    
    
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomSurname() {
        return customSurname;
    }

    public void setCustomSurname(String customSurname) {
        this.customSurname = customSurname;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }
    
    
}
