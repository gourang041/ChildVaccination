package com.parent_service.DTO;

import java.time.LocalDate;

public class ChildDTO {

    private Long id;
    private String childName;
    private String gender;
    private LocalDate dateOfBirth;
    private Long parentId;

    public ChildDTO() {
    }

    public ChildDTO(Long id, String childName, String gender, LocalDate dateOfBirth, Long parentId) {
        this.id = id;
        this.childName = childName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.parentId = parentId;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
