/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.dto;

import javax.validation.constraints.NotNull;



/**
 *
 * @author User
 */
public class LoginDTO{

    @NotNull
    public String username;
    @NotNull
    public String password;
}
