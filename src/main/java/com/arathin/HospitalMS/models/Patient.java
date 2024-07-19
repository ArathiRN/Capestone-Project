package com.arathin.HospitalMS.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.Set;

@Data
@Entity
@Table
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Appointment> appointments;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<HealthRecord> healthRecords;
}
