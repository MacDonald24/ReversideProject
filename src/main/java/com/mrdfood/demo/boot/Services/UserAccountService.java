/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.Person;
import com.mrdfood.demo.boot.model.UserAccount;
import java.util.List;

/**
 *
 * @author User
 */
public interface UserAccountService {
    
    public UserAccount create(Person person);
    public UserAccount createPartner(Person person);
     public UserAccount createDriver(Person person);
    public List<UserAccount> findAll();
    public UserAccount update(UserAccount userAccount);
    public UserAccount delete(String id);
    public UserAccount findByUsername(String username);
    public UserAccount findByUsernameAndPassword(String username,String password);
    public UserAccount findById(String Id);
    
}
