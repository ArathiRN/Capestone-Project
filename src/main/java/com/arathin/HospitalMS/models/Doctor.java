package com.arathin.HospitalMS.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

import org.springframework.data.annotation.Id;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<Appointment> appointments;
}
