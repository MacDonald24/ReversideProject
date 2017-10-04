/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.repository;

import com.mrdfood.demo.boot.model.PartnerRequest;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Repository
@Transactional
public interface PartnerRequestRepository extends MongoRepository<PartnerRequest, String>{
    
    PartnerRequest save(PartnerRequest partnerRequest);
    List<PartnerRequest> findAll();
    PartnerRequest findOne(String id);
}
