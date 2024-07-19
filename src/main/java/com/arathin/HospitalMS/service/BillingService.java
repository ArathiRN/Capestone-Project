package com.arathin.HospitalMS.service;

import com.arathin.HospitalMS.models.Billing;
import com.arathin.HospitalMS.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public List<Billing> findAll() {
        return billingRepository.findAll();
    }

    public Billing findById(Long id) {
        return billingRepository.findById(id).orElse(null);
    }

    public Billing save(Billing billing) {
        return billingRepository.save(billing);
    }

    public void deleteById(Long id) {
        billingRepository.deleteById(id);
    }
}
