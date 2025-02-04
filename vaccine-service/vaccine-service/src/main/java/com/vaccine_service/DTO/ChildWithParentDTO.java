package com.vaccine_service.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ChildWithParentDTO {

    private Long id;
    private String childName;
    private String gender;

    private LocalDate dateOfBirth;
    @JsonProperty("parent") //This will rename parentDTO to parent in the Json Response.
    private ParentDTO parentDTO;

    public ChildWithParentDTO(Long id, String childName, String gender, LocalDate dateOfBirth, ParentDTO parentDTO) {
        this.id = id;
        this.childName = childName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.parentDTO = parentDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ParentDTO getParentDTO() {
        return parentDTO;
    }

    public void setParentDTO(ParentDTO parentDTO) {
        this.parentDTO = parentDTO;
    }
}
