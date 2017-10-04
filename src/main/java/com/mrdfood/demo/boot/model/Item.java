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
public class Item {
         private static final long serialVersionUID = -723583058586873479L;
    @Id
    @Field
    private String itemId;
    @Field
    private String name;
    @Field
    private String shortDescription;
    @Field
    private double price;
    @Field
    private String categoryId;
    @Field
    private double quantity;
    
    public Item() {
    }

    public Item(String itemId, String name, String shortDescription, double price, String categoryId, double quantity) {
        this.itemId = itemId;
        this.name = name;
        this.shortDescription = shortDescription;
        this.price = price;
        this.categoryId = categoryId;
        this.quantity = quantity;
    }
    
    
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", name=" + name + ", shortDescription=" + shortDescription + ", price=" + price + ", categoryId=" + categoryId + ", quantity=" + quantity + '}';
    }

    
   
}
