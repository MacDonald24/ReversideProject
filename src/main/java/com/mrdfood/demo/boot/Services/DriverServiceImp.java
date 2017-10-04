/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.DriverRequest;
import com.mrdfood.demo.boot.repository.DriverRequestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DriverServiceImp implements DriverService{

    @Autowired
    private final DriverRequestRepository driverRequestRepository;
    
    @Autowired
    DriverServiceImp(DriverRequestRepository driverRequestRepository)
    {
        this.driverRequestRepository = driverRequestRepository;
    }
            
    @Override
    public List<DriverRequest> findAll() {
        
        List<DriverRequest> driverRequests = driverRequestRepository.findAll();
        
        return driverRequests;
    }

    @Override
    public DriverRequest create(DriverRequest driverRequest) {
        
        DriverRequest saveDriverRequest = driverRequestRepository.save(driverRequest);
        
        return saveDriverRequest;
    }

    @Override
    public DriverRequest delete(String id) {
       
         DriverRequest savedDriverRequest = driverRequestRepository.findOne(id);
         driverRequestRepository.delete(savedDriverRequest);
        return savedDriverRequest;
    }

    @Override
    public DriverRequest findById(String id) {
        DriverRequest savedDriverRequest = driverRequestRepository.findOne(id);
        return savedDriverRequest;
    }
    
}
