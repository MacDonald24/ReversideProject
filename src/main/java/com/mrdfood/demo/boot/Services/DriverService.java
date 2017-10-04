/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.DriverRequest;
import com.mrdfood.demo.boot.model.PartnerRequest;
import java.util.List;

/**
 *
 * @author User
 */
public interface DriverService {
    public List<DriverRequest> findAll();
    public DriverRequest create(DriverRequest driverRequest);
     public DriverRequest findById(String id);
    public DriverRequest delete(String id);
}
