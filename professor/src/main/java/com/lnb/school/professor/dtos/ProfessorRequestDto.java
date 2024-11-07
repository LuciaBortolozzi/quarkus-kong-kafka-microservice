package com.lnb.school.professor.dtos;

public class ProfessorRequestDto {
    private String pidn;
    private String name;
    private String email;
    private String phone;
    private String major;

    public String getPidn() {
        return pidn;
    }

    public void setPidn(String pidn) {
        this.pidn = pidn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}