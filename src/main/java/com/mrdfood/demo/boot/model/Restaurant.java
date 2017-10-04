/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author User
 */
@Document
public class Restaurant implements Serializable {
        private static final long serialVersionUID = -723583058586873479L;
    @Id
    @Field
    private String restaurantId;
    @Field
    private String accountId;
    @Field
    private String name;
    @Field
    private String address;
    @Field
    private String image; 
    @Field
    private List<Category> categories;
    
    public Restaurant() {
    }

    public Restaurant(String restaurantId, String accountId, String name, String address, String image) {
        this.restaurantId = restaurantId;
        this.accountId = accountId;
        this.name = name;
        this.address = address;
        this.image = image;
  
    }
    
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Category> getCategoryId() {
        return categories;
    }

    public void setCategoryId(List<Category> categories) {
        this. categories = categories;
    }

   
    public void addCategories(Category... categories) {
        if(this.categories == null) this.categories = new ArrayList<>();
        this.categories.addAll(Arrays.asList(categories));
    }
    
}
