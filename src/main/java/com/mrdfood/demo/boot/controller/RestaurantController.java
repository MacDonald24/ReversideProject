/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.controller;


import com.mrdfood.demo.boot.Services.ItemService;
import com.mrdfood.demo.boot.model.Category;
import com.mrdfood.demo.boot.model.Item;
import com.mrdfood.demo.boot.model.Restaurant;
import com.mrdfood.demo.boot.model.ValidationError;
import com.mrdfood.demo.boot.repository.CategoryRepository;
import com.mrdfood.demo.boot.repository.ItemRepository;
import com.mrdfood.demo.boot.repository.RestaurantRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/api/restaurant")
public class RestaurantController {
   
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MongoTemplate mongoOperation;
    @Autowired
    ItemRepository itemRepository;
    
    @Autowired
    ItemService itemService;
    
    
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Restaurant> save(@RequestBody @Valid Restaurant restaurant, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
        
		Restaurant savedRestaurant = restaurantRepository.save(restaurant);
                
        return new ResponseEntity<>(savedRestaurant, HttpStatus.OK);
    }
    
       
    @RequestMapping(value="/all" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getRestaurants() {
       return restaurantRepository.findAll();
    }
    @RequestMapping(value="items/all" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getItems() {
       return itemRepository.findAll();
    }
    
    
    @RequestMapping(value="/menu/categories/all" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getCategories() {
       return categoryRepository.findAll();
    }
    
    @RequestMapping(value = "/get/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Restaurant> getUserAccount(@PathVariable String accountId) {
        
            Query query = new Query(Criteria.where("accountId").is(accountId));
            
            Restaurant restuarant = mongoOperation.findOne(query, Restaurant.class,"restaurant");
            
            
       return new ResponseEntity<>(restuarant, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/menu/category",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Category> save(@RequestBody @Valid Category category, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
        Category savedCategory = null;
            if(category != null)
            {
              savedCategory = categoryRepository.save(category); 
            }
		
        return new ResponseEntity<>(savedCategory, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Category>  getRestCategories(@PathVariable String categoryId) {
 
             Query query = new Query(Criteria.where("_id").is(categoryId));
            Category category = mongoOperation.findOne(query,Category.class,"category");

            
         return new ResponseEntity< >(category, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/addCategories/{accountId}", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Restaurant> addCategoriesToRest(@PathVariable String accountId,@RequestBody @Valid Category category) {
        
            Query query = new Query(Criteria.where("accountId").is(accountId));
            
            Restaurant restuarant = mongoOperation.findOne(query, Restaurant.class,"restaurant");
            
            restuarant.addCategories(category);
            
            mongoOperation.save(restuarant);
            
            return new ResponseEntity<>(restuarant, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/category/item",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Item> save(@RequestBody @Valid Item item, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
                itemRepository.save(item); 	
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @RequestMapping(value = "/category/item/{itemId}",method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Item> getItemById(@PathVariable String itemId) throws Exception {
       Query query = new Query(Criteria.where("_id").is(itemId));
       Item item = mongoOperation.findOne(query, Item.class, "item");
       return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @RequestMapping(value = "/addItems/{categoryId}",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Category> addItems(@PathVariable String categoryId,@RequestBody @Valid Item item) throws Exception {
            Query query = new Query(Criteria.where("_id").is(categoryId));
            
            Category category = mongoOperation.findOne(query, Category.class,"category");
            
            category.addCategories(item);
            categoryRepository.save(category); 	
            
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    
    /*@RequestMapping(value = "/category/item/{categoryId}",method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Item> retrieveItemByCategoryId(@PathVariable String categoryId) throws Exception {
      	
        Item item = itemService.getItemByCategoryId(categoryId);
        
        return new ResponseEntity<>(item, HttpStatus.OK);
    }*/
    
    @RequestMapping(value="/menu/items/{categoryId}" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getItemsByCategoryId(@PathVariable String categoryId) {
       

        Query query = new Query(Criteria.where("categoryId").is(categoryId));
        
        List<Item> items = mongoOperation.find(query, Item.class, "item");
                
        return items;
    }
    
    
}
