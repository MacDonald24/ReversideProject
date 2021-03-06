/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.controller;

import com.mrdfood.demo.boot.Services.DriverServiceImp;
import com.mrdfood.demo.boot.model.DriverRequest;
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

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api/driverRequest")
public class DriverRequestController {
    
    @Autowired
    DriverServiceImp driverServiceImp;
    
       @RequestMapping(value="/all" ,method = RequestMethod.GET)
    @ResponseBody
    public List<DriverRequest> getPeople() {
       return driverServiceImp.findAll();
    }
    
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<DriverRequest> save(@RequestBody @Valid DriverRequest driverRequest, BindingResult bindingResult) throws Exception {

         DriverRequest saveDriverRequest = driverServiceImp.create(driverRequest);
           
        return new ResponseEntity<DriverRequest>(saveDriverRequest, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    ResponseEntity<DriverRequest> deleteDriverRequest(@PathVariable @Valid String id) throws Exception {

         DriverRequest saveDriverRequest = driverServiceImp.delete(id);
           
        return new ResponseEntity<DriverRequest>(saveDriverRequest, HttpStatus.OK);
    }
    
}