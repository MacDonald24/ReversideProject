/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.model;

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
public class Category {
    
    @Id
    private String categoryId;
    @Field
    private String name;
    @Field
    private String restaurantId;
    @Field
    private List<Item> items;
    
    public Category() {
    }

    public Category(String categoryId, String name, String restaurantId) {
        this.categoryId = categoryId;
        this.name = name;
        this.restaurantId = restaurantId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItemIds(List<Item> items) {
        this.items = items;
    }

    public void addCategories(Item... items) {
        if(this.items == null) this.items = new ArrayList<>();
        this.items.addAll(Arrays.asList(items));
    } 
}
