package com.arathin.HospitalMS.service;

import com.arathin.HospitalMS.models.HealthRecord;
import com.arathin.HospitalMS.repository.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthRecordService {
    @Autowired
    private HealthRecordRepository healthRecordRepository;

    public List<HealthRecord> findAll() {
        return healthRecordRepository.findAll();
    }

    public HealthRecord findById(Long id) {
        return healthRecordRepository.findById(id).orElse(null);
    }

    public HealthRecord save(HealthRecord healthRecord) {
        return healthRecordRepository.save(healthRecord);
    }

    public void deleteById(Long id) {
        healthRecordRepository.deleteById(id);
    }

}
