package com.arathin.HospitalMS.repository;

import com.arathin.HospitalMS.models.HealthRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {


}
