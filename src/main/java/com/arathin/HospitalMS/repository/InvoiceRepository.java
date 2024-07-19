package com.arathin.HospitalMS.repository;

import com.arathin.HospitalMS.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
