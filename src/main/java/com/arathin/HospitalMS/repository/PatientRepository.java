package com.arathin.HospitalMS.repository;

import com.arathin.HospitalMS.models.Patient;
import com.arathin.HospitalMS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
    Patient findByUsername(String username);
}
