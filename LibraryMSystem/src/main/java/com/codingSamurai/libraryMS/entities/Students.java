package com.codingSamurai.libraryMS.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String course;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "students", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Loan> borrowedBooks;



    public Students(Long id, String name, String course, String email, String phone, List<Loan> borrowedBooks, List<Loan> returnedBooks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.email = email;
        this.phone = phone;
        this.borrowedBooks = borrowedBooks;
//        this.returnedBooks = returnedBooks;
    }

    public Students() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Loan> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Loan> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

//    public List<Loan> getReturnedBooks() {
//        return returnedBooks;
//    }

//    public void setReturnedBooks(List<Loan> returnedBooks) {
//        this.returnedBooks = returnedBooks;
//    }


}
