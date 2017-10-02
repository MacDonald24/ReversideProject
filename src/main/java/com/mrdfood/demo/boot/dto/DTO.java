/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
public abstract class DTO {
           static final long serialVersionUID = -7035787898656666939L;

    @NotNull
    @Min(3)
    public String oid;

    //json representation of business key if defined
    public String businessKey;
}