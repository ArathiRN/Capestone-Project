package com.arathin.HospitalMS.repository;

import com.arathin.HospitalMS.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
