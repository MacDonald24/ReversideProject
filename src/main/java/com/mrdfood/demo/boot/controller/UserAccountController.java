/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.controller;

import com.mrdfood.demo.boot.Services.UserAccountServiceImp;
import com.mrdfood.demo.boot.dto.LoginDTO;
import com.mrdfood.demo.boot.model.Person;
import com.mrdfood.demo.boot.model.UserAccount;
import com.mrdfood.demo.boot.model.ValidationError;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userAccount")
public class UserAccountController {
    
    @Autowired
    private UserAccountServiceImp userAccountServiceImp;
    
     @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserAccount> save(@RequestBody @Valid Person person, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
        
               UserAccount savedAccount = userAccountServiceImp.create(person);
   
        return new ResponseEntity<>(savedAccount , HttpStatus.OK);
    }
    @RequestMapping(value = "/partner/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserAccount> savePartner(@RequestBody @Valid Person person, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
               UserAccount savedUser = userAccountServiceImp.createPartner(person);
           
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
    @RequestMapping(value = "/driver/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserAccount> saveDriver(@RequestBody @Valid Person person, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
               UserAccount savedUser = userAccountServiceImp.createDriver(person);
           
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<UserAccount> getUserAccount(@PathVariable @Valid  String username) {
        
        UserAccount savedUserAccount = userAccountServiceImp.findByUsername(username);
        
       return new ResponseEntity<>(savedUserAccount, HttpStatus.OK);
    } 
    

    @RequestMapping(value="/userAccounts/all" ,method = RequestMethod.GET)
    @ResponseBody
    List<UserAccount> getAccounts() {
        return userAccountServiceImp.findAll();
    }
    
    @RequestMapping(value = "/session/login", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserAccount> getLogin(@RequestBody @Valid  LoginDTO loginDto) {
       
      UserAccount savedUserAccount = userAccountServiceImp.findByUsernameAndPassword(loginDto.username, loginDto.password);
             
       return new ResponseEntity<>(savedUserAccount, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserAccount> updateAccount(@RequestBody @Valid UserAccount userAccount, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
        
          UserAccount updatedAccount = userAccountServiceImp.update(userAccount);

        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }
     @RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    ResponseEntity<UserAccount> deleteUserAccount(@PathVariable @Valid String id) throws Exception {
       
        
          UserAccount deletedAccount = userAccountServiceImp.delete(id);

        return new ResponseEntity<>(deletedAccount, HttpStatus.OK);
    }
    
}
