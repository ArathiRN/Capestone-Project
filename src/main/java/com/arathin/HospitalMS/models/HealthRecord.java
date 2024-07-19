package com.arathin.HospitalMS.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}
