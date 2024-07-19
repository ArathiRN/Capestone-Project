package com.arathin.HospitalMS.controllers;

import ch.qos.logback.core.model.Model;
import com.arathin.HospitalMS.models.Patient;
import com.arathin.HospitalMS.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public String getAllPatients(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "patients/list";
    }

    @GetMapping("/new")
    public String createPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patients/form";
    }

    @PostMapping
    public String createPatient(@ModelAttribute Patient patient) {
        patientService.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}")
    public String getPatientById(@PathVariable Long id, Model model) {
        Patient patient = patientService.findById(id);
        model.addAttribute("patient", patient);
        return "patients/detail";
    }

    @GetMapping("/{id}/edit")
    public String updatePatientForm(@PathVariable Long id, Model model) {
        Patient patient = patientService.findById(id);
        model.addAttribute("patient", patient);
        return "patients/form";
    }

    @PostMapping("/{id}")
    public String updatePatient(@PathVariable Long id, @ModelAttribute Patient patient) {
        patient.setId(id);
        patientService.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}/delete")
    public String deletePatient(@PathVariable Long id) {
        patientService.deleteById(id);
        return "redirect:/patients";
    }
}
