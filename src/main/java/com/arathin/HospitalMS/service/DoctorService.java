package com.arathin.HospitalMS.service;

import com.arathin.HospitalMS.models.Doctor;
import com.arathin.HospitalMS.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }
}
