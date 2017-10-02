package com.mrdfood.demo.boot.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="account")
public class UserAccount implements Serializable {
        private static final long serialVersionUID = -723583058586873479L;
    @Id
    @Field
    private String accountId;
    
    @Field
    private String personId; 
    
    @Field
    private String username;//email address

    @Field
    private String password;

    @Field
    private String role;

    public UserAccount() {
    }

    public UserAccount(String accountId, String username, String password, String role) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserAccount{" + "accountId=" + accountId + ", personId=" + personId + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }

    public void getPersonId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
