/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.controller;

import com.mrdfood.demo.boot.model.PartnerRequest;
import com.mrdfood.demo.boot.repository.PartnerRequestRepository;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/partnerRequest")
@Api(value = "PartnerRequestControllerAPI" ,produces = MediaType.APPLICATION_JSON_VALUE )
public class PartnerRequestController {
    
   @Autowired
   PartnerRequestRepository partnerRequestRepository;
           
       @RequestMapping(value="/all" ,method = RequestMethod.GET)
    @ResponseBody
    public List<PartnerRequest> getPeople() {
       return partnerRequestRepository.findAll();
    }
    
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<PartnerRequest> save(@RequestBody @Valid PartnerRequest partnerRequest, BindingResult bindingResult) throws Exception {
      
        PartnerRequest toPartner = new PartnerRequest();
        
        toPartner.setFullName(partnerRequest.getFullName());
        toPartner.setEmailAddres(partnerRequest.getEmailAddres());
        toPartner.setPhoneNumber(partnerRequest.getPhoneNumber());
        toPartner.setLocation(partnerRequest.getLocation());
        toPartner.setRestuarantName(partnerRequest.getRestuarantName());
        
         PartnerRequest savePartnerRequest = partnerRequestRepository.save(toPartner);
           
        return new ResponseEntity<PartnerRequest>(savePartnerRequest, HttpStatus.OK);
    }
}
