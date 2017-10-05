/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.model;

import java.util.List;

/**
 *
 * @author User
 */
public class Address {
                  private static final long serialVersionUID = -723583058586873479L;
    private String streetName;
    private String city;
    private String zipCode;
    private String province;
    private List<String> ordinates;

    public Address() {
    }

    public Address(String streetName, String city, String zipCode, String province) {
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
        this.province = province;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getOrdinates() {
        return ordinates;
    }

    public void setOrdinates(List<String> ordinates) {
        this.ordinates = ordinates;
    }
   
    
    
}
