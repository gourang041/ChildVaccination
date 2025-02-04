package com.vaccine_service.DTO;

public class ParentDTO {

    private Long id;
    private String fatherName;
    private String motherName;
    private String mobile;
    private String mailId;

    public ParentDTO(Long id, String fatherName, String motherName, String mobile, String mailId) {
        this.id = id;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.mobile = mobile;
        this.mailId = mailId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
}
