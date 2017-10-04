/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.PartnerRequest;
import java.util.List;

/**
 *
 * @author User
 */
public interface PartnerService {
     public List<PartnerRequest> findAll();
     public PartnerRequest create(PartnerRequest partnerRequest);
     public PartnerRequest delete(String id);
     public PartnerRequest findById(String id);
}
