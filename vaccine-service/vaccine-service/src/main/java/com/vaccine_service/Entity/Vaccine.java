package com.vaccine_service.Entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

import java.time.LocalDate;

@Entity
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vaccineName;
    private LocalDate dateOfAdministration;
    private String dosage;

    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public LocalDate getDateOfAdministration() {
        return dateOfAdministration;
    }

    public void setDateOfAdministration(LocalDate dateOfAdministration) {
        this.dateOfAdministration = dateOfAdministration;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
