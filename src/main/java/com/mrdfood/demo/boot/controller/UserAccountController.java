/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.controller;

import com.mrdfood.demo.boot.dao.UserAccountDao;
import com.mrdfood.demo.boot.dto.LoginDTO;
import com.mrdfood.demo.boot.model.Person;
import com.mrdfood.demo.boot.repository.PersonRepository;
import com.mrdfood.demo.boot.model.UserAccount;
import com.mrdfood.demo.boot.repository.UserAccountRepository;
import com.mrdfood.demo.boot.model.ValidationError;
import com.mrdfood.demo.boot.util.EmailUtil;
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

@RestController
@RequestMapping("/api/userAccount")
public class UserAccountController {
    
    @Autowired
    private UserAccountRepository userAccRepository;
    @Autowired
    MongoTemplate mongoOperation;
    @Autowired
    UserAccountDao userAccountDao;
    @Autowired
    private PersonRepository personRepository;
    
     @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserAccount> save(@RequestBody @Valid Person person, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
        
		
                Person savedUser = personRepository.save(person);
                
                UserAccount userRep = new UserAccount();
                if(savedUser != null)
                {
                    
                    Person user = personRepository.findOne(savedUser.getId());
                    userRep.setPersonId(user.getId());
                    userRep.setUsername(user.getEmail());
                    userRep.setPassword(user.getPassword());
                    userRep.setRole("Customer");
                }
               UserAccount savedAccount = userAccRepository.save(userRep);
    
           
        return new ResponseEntity<>(savedAccount , HttpStatus.OK);
    }
      @RequestMapping(value = "/partner/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserAccount> savePartner(@RequestBody @Valid Person person, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
                Person user = personRepository.save(person);
                
                UserAccount userRep = new UserAccount();
                if(user != null)
                {
                    userRep.setUsername(user.getEmail());
                    userRep.setPersonId(user.getId());
                    userRep.setPassword(user.getPassword());
                    userRep.setRole("Partner");
                }
               UserAccount savedUser = userAccRepository.save(userRep);
           
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<UserAccount> getUserAccount(@PathVariable String username) {
        
            Query query = new Query(Criteria.where("username").is(username));
        
            UserAccount userAccount = mongoOperation.findOne(query, UserAccount.class,"account") ;
     
        
       return new ResponseEntity<>(userAccount, HttpStatus.OK);
    } 
    

    @RequestMapping(value="/userAccounts/all" ,method = RequestMethod.GET)
    @ResponseBody
    List<UserAccount> getAccounts() {
        return userAccRepository.findAll();
    }
    
    @RequestMapping(value = "/session/login", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserAccount> getLogin(@RequestBody @Valid  LoginDTO loginDto) {
       
            Query query = new Query(Criteria.where("username").is(loginDto.username).and("password").is(loginDto.password) );
        
             UserAccount userAccount = mongoOperation.findOne(query, UserAccount.class,"account") ;
            
             
       return new ResponseEntity<>(userAccount, HttpStatus.OK);
    } 
    
      @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UserAccount> updateAccount(@RequestBody @Valid UserAccount userAccount, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
        
          UserAccount updatedAccount = userAccountDao.accountUpdate(userAccount);

        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }
    
}
