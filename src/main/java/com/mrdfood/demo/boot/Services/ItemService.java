/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Item;
import java.util.List;



/**
 *
 * @author User
 */

public interface ItemService {

    public List<Item> findAll();
    public Item find(String itemId);
 
}
