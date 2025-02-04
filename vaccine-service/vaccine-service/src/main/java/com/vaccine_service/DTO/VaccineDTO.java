package com.vaccine_service.DTO;

import java.time.LocalDate;

public class VaccineDTO {

    private Long id;
    private String vaccineName;
    private LocalDate dateOfAdministration;
    private String dosage;
    private Long childId;

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

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }
}
