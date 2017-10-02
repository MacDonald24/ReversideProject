/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.controller;

import com.mrdfood.demo.boot.Services.ItemService;
import com.mrdfood.demo.boot.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {
 
   @Autowired
   private ItemService itemService; 
          List<Item> cart = new ArrayList<>();
    @RequestMapping(value="/addItem" ,method = RequestMethod.POST)
    @ResponseBody
    List<Item> add(@RequestBody @Valid Item item,HttpSession session) {

        if(session.getAttribute("cart") == null)
        {
            cart.add(item);
            session.setAttribute("cart", cart);
        }else
        {
            cart = (List<Item>) session.getAttribute("cart");
            int index = isExists(item.getItemId(), cart);
            if(index == -1)
            {
                  cart.add(item);
            }else
            {
                double quantity =  cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
        }
        
        return cart;
    }
    @RequestMapping(value="/removeItem/{itemId}" ,method = RequestMethod.GET)
    @ResponseBody
    Item remove(@PathVariable @Valid String itemId,HttpSession session) {
    
        Item item = null;
               cart = (List<Item>) session.getAttribute("cart");
               
               int index = isExists(itemId, cart);  
               item = cart.remove(index);
               session.setAttribute("cart", cart);
        return item;
    };
    
    @RequestMapping(value="/items" ,method = RequestMethod.GET)
    @ResponseBody
    List<Item> getShoppingCartItems(HttpSession session) {
        if(session.getAttribute("cart") == null)
        {
            cart = (List<Item>) session.getAttribute("cart");
        }
        return cart;
    }
    
    private int isExists(String itemId,List<Item> cart)
    {
        for(int i = 0 ; i < cart.size() ; i++)
        {
            if(cart.get(i).getItemId() == null ? itemId == null : cart.get(i).getItemId().equals(itemId) )
            {
                return i;
            }
        }
        
        return -1;
    }
    
    
}
