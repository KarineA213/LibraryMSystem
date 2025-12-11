package com.codingSamurai.libraryMS.dto;

import com.codingSamurai.libraryMS.entities.Loan;
import com.codingSamurai.libraryMS.entities.Students;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentsDto {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String course;
    @Email
    private String email;
    @NotBlank
    private String phone;
    private List<StudentsLoansDto> studentsLoans;

    public StudentsDto() {
    }

    public StudentsDto(Long id, String name, String course, String email, String phone,

                       List<LoanDto> borrowedBooks, List<LoanDto> returnedBooks, List<StudentsLoansDto> studentsLoans) {

        this.id = id;
        this.name = name;
        this.course = course;
        this.email = email;
        this.phone = phone;
        this.studentsLoans = studentsLoans;

//        this.loans =  new ArrayList<StudentsLoansDto>();
//        this.borrowedBooks = borrowedBooks;
//        this.returnedBooks = returnedBooks;
    }



    public StudentsDto(Students entity) {
        id = entity.getId();
        name = entity.getName();
        course = entity.getCourse();
        email = entity.getEmail();
        phone = entity.getPhone();
        this.studentsLoans = Optional.ofNullable(entity.getBorrowedBooks())
                .orElseGet(ArrayList::new)
                .stream()
                .flatMap(loan -> loan.getLoanItems().stream())//flatmap achata tudo e faz tudo parecer um grande loan com apenas informações importantes
                .map(StudentsLoansDto::new).collect(Collectors.toList());

    }

    public List<StudentsLoansDto> getStudentsLoans() {
        return studentsLoans;
    }

    public void setStudentsLoans(List<StudentsLoansDto> studentsLoans) {
        this.studentsLoans = studentsLoans;
    }

    public Long getId() {

        return id;

    }

    public String getName() {

        return name;

    }

    public String getCourse() {

        return course;

    }


   public String getEmail() {

        return email;

    }

    public String getPhone() {

        return phone;

    }



    public void setId(Long id) {

        this.id = id;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void setCourse(String course) {

        this.course = course;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public void setPhone(String phone) {

        this.phone = phone;

    }

}