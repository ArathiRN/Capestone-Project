package com.arathin.HospitalMS.repository;

import com.arathin.HospitalMS.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
