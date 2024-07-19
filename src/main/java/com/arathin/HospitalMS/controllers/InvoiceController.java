package com.arathin.HospitalMS.controllers;

import com.arathin.HospitalMS.models.Invoice;
import com.arathin.HospitalMS.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public String getAllInvoices(Model model) {
        List<Invoice> invoices = invoiceService.findAll();
        model.addAttribute("invoices", invoices);
        return "invoices/list";
    }

    @GetMapping("/new")
    public String createInvoiceForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "invoices/form";
    }

    @PostMapping
    public String createInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/{id}")
    public String getInvoiceById(@PathVariable Long id, Model model) {
        Invoice invoice = invoiceService.findById(id);
        model.addAttribute("invoice", invoice);
        return "invoices/detail";
    }

    @GetMapping("/{id}/edit")
    public String updateInvoiceForm(@PathVariable Long id, Model model) {
        Invoice invoice = invoiceService.findById(id);
        model.addAttribute("invoice", invoice);
        return "invoices/form";
    }

    @PostMapping("/{id}")
    public String updateInvoice(@PathVariable Long id, @ModelAttribute Invoice invoice) {
        invoice.setId(id);
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/{id}/delete")
    public String deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteById(id);
        return "redirect:/invoices";
    }
}
