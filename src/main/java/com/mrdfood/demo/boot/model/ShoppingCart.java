/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ShoppingCart {
    List<Item> cartItems = new ArrayList<>();
    
    public void addItemToCartByPID(String itemId) {
        Item item = getItemByItemID(itemId);
        addToCart(item);
    }

    private Item getItemByItemID(String itemId) {
        Item theItem = null;
        List<Item> items = new Category().getItems();
        for (Item item: items) {
            if (item.getItemId().equals(itemId)) {
                theItem = item;
                break;
            }
        }
        return theItem;
    }

    private void addToCart(Item item) {
        cartItems.add(item);
    }

    public void removeItemByPID(String itemId) {
        Item item = getItemByItemID(itemId);
        cartItems.remove(item);
    }

}
