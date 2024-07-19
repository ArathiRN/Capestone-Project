package com.arathin.HospitalMS.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "billing_id", nullable = false)
    private Billing billing;

    private LocalDateTime invoiceDate;
    private String details;
    private Double amount;
}
