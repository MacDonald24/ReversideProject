/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.Services;

import com.mrdfood.demo.boot.model.PartnerRequest;
import com.mrdfood.demo.boot.repository.PartnerRequestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class PartnerServiceImp implements PartnerService{

    @Autowired
    private final PartnerRequestRepository partnerRequestRepository;
    
    @Autowired
    PartnerServiceImp(PartnerRequestRepository partnerRequestRepository)
    {
        this.partnerRequestRepository = partnerRequestRepository;
    }
    @Override
    public List<PartnerRequest> findAll() {
        
       List<PartnerRequest> partners = partnerRequestRepository.findAll();
       
       return partners;
    }

    @Override
    public PartnerRequest create(PartnerRequest partnerRequest) {
        
       PartnerRequest savedPartnerRequest = partnerRequestRepository.save(partnerRequest);
       
       return savedPartnerRequest;
        
    }

    @Override
    public PartnerRequest delete(String id) {
        PartnerRequest savedPartnerRequest = findById(id) ;
        
        partnerRequestRepository.delete(savedPartnerRequest);
        
        return savedPartnerRequest;
        
    }

    @Override
    public PartnerRequest findById(String id) {
       PartnerRequest savedPartnerRequest = partnerRequestRepository.findOne(id);
       return savedPartnerRequest;
    }
    
   
}
