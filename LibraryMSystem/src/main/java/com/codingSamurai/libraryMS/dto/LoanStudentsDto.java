package com.codingSamurai.libraryMS.dto;

import com.codingSamurai.libraryMS.entities.Students;

public class LoanStudentsDto {

    private String name;
    private String course;
    private String email;
    private String phone;


    public LoanStudentsDto() {
    }

    public LoanStudentsDto(String name, String course, String email, String phone) {
        this.name = name;
        this.course = course;
        this.email = email;
        this.phone = phone;
    }


    public LoanStudentsDto(Students entity) {
        name = entity.getName();
        course = entity.getCourse();
        email = entity.getEmail();
        phone = entity.getPhone();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
