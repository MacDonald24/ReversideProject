/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.model;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author User
 */
@Document
public class Order {
                  private static final long serialVersionUID = -723583058586873479L;
    private String id;
    private String orderNum;
    private String personId;
    private String buildingType;
    private String buildingTypeSpecific;
    private String restaurantName;
    private String toAddress;
    private String deliveryInstruction;
    private String paymentMethod;
    private double foodTotal;
    private double serviceFee;
    private double total;
    private String date;
    private String status;
    private List<Item> items;

    public Order() {
    }

    public Order(String id, String orderNum,String personId, String buildingType,String buildingTypeSpecific,String restaurantName, String toAddress, String deliveryInstruction, String paymentMethod, double foodTotal, double serviceFee, double total, String status, List<Item> items) {
        this.id = id;
        this.orderNum = orderNum;
        this.personId = personId;
        this.buildingType = buildingType;
        this.buildingTypeSpecific = buildingTypeSpecific;
        this.restaurantName = restaurantName;
        this.toAddress = toAddress;
        this.deliveryInstruction = deliveryInstruction;
        this.paymentMethod = paymentMethod;
        this.foodTotal = foodTotal;
        this.serviceFee = serviceFee;
        this.total = total;
        this.status = status;
        this.items = items;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getBuildingTypeSpecific() {
        return buildingTypeSpecific;
    }

    public void setBuildingTypeSpecific(String buildingTypeSpecific) {
        this.buildingTypeSpecific = buildingTypeSpecific;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getDeliveryInstruction() {
        return deliveryInstruction;
    }

    public void setDeliveryInstruction(String deliveryInstruction) {
        this.deliveryInstruction = deliveryInstruction;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getFoodTotal() {
        return foodTotal;
    }

    public void setFoodTotal(double foodTotal) {
        this.foodTotal = foodTotal;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
       
    
}
