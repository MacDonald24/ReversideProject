/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author User
 */
@Document
public class DriverRequest {
    
    @Id
    @Field
    private String driverReq;
    @Field
    private String fullName;
    @Field
    private String phoneNumber;
    @Field
    private String emailAddress;
    @Field
    private String location;
    @Field
    private String transport;
    @Field
    private String licenece;
    @Field
    private String jobTime;
    @Field
    private String avaliabilty;

    public DriverRequest() {
    }

    public DriverRequest(String driverReq, String fullName, String phoneNumber, String location, String transport, String licenece, String jobTime, String avaliabilty) {
        this.driverReq = driverReq;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.transport = transport;
        this.licenece = licenece;
        this.jobTime = jobTime;
        this.avaliabilty = avaliabilty;
    }

    public String getDriverReq() {
        return driverReq;
    }

    public void setDriverReq(String driverReq) {
        this.driverReq = driverReq;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getLicenece() {
        return licenece;
    }

    public void setLicenece(String licenece) {
        this.licenece = licenece;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public String getAvaliabilty() {
        return avaliabilty;
    }

    public void setAvaliabilty(String avaliabilty) {
        this.avaliabilty = avaliabilty;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "DriverRequest{" + "driverReq=" + driverReq + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", location=" + location + ", transport=" + transport + ", licenece=" + licenece + ", jobTime=" + jobTime + ", avaliabilty=" + avaliabilty + '}';
    }

  
    
    
            
}
