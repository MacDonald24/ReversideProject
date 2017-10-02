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
public class PartnerRequest {
    
    @Id
    @Field
    private String partnerRequestId;
    
    @Field
    private String fullName;
    
    @Field
    private String phoneNumber;
    @Field
    private String emailAddres;
    @Field
    private String location;
    @Field
    private String restuarantName;
    @Field
    private String additionalInfo;

    public PartnerRequest() {
    }

    public PartnerRequest(String partnerRequestId, String phoneNumber, String emailAddres, String location, String additionalInfo) {
        this.partnerRequestId = partnerRequestId;
        this.phoneNumber = phoneNumber;
        this.emailAddres = emailAddres;
        this.location = location;
        this.additionalInfo = additionalInfo;
    }

    public String getPartnerRequestId() {
        return partnerRequestId;
    }

    public void setPartnerRequestId(String partnerRequestId) {
        this.partnerRequestId = partnerRequestId;
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

    public String getEmailAddres() {
        return emailAddres;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRestuarantName() {
        return restuarantName;
    }

    public void setRestuarantName(String restuarantName) {
        this.restuarantName = restuarantName;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "PartnerRequest{" + "partnerRequestId=" + partnerRequestId + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", emailAddres=" + emailAddres + ", location=" + location + ", restuarantName=" + restuarantName + ", additionalInfo=" + additionalInfo + '}';
    }

   
    
    
    
}
