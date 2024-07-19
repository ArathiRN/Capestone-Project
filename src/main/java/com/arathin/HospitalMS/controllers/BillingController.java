package com.arathin.HospitalMS.controllers;

import com.arathin.HospitalMS.models.Billing;
import com.arathin.HospitalMS.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/billings")
public class BillingController {
    @Autowired
    private BillingService billingService;

    @GetMapping
    public String getAllBillings(Model model) {
        List<Billing> billings = billingService.findAll();
        model.addAttribute("billings", billings);
        return "billings/list";
    }

    @GetMapping("/new")
    public String createBillingForm(Model model) {
        model.addAttribute("billing", new Billing());
        return "billings/form";
    }

    @PostMapping
    public String createBilling(@ModelAttribute Billing billing) {
        billingService.save(billing);
        return "redirect:/billings";
    }

    @GetMapping("/{id}")
    public String getBillingById(@PathVariable Long id, Model model) {
        Billing billing = billingService.findById(id);
        model.addAttribute("billing", billing);
        return "billings/detail";
    }

    @GetMapping("/{id}/edit")
    public String updateBillingForm(@PathVariable Long id, Model model) {
        Billing billing = billingService.findById(id);
        model.addAttribute("billing", billing);
        return "billings/form";
    }

    @PostMapping("/{id}")
    public String updateBilling(@PathVariable Long id, @ModelAttribute Billing billing) {
        billing.setId(id);
        billingService.save(billing);
        return "redirect:/billings";
    }

    @GetMapping("/{id}/delete")
    public String deleteBilling(@PathVariable Long id) {
        billingService.deleteById(id);
        return "redirect:/billings";
    }
}
