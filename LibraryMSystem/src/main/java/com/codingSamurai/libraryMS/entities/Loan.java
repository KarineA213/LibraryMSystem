package com.codingSamurai.libraryMS.entities;
import com.codingSamurai.libraryMS.entities.enums.LoanStatus;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
    private List<LoanItems> loanItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "students_id")
    private Students students;

    private LocalDateTime loanDate;
    private LocalDateTime dueDate;

    @Column(nullable = true)
    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    public Loan() {
    }

    public Loan(Long id, List<LoanItems> loanItems, Students students, LocalDateTime loanDate, LocalDateTime dueDate, LocalDateTime returnDate, LoanStatus status) {
        this.id = id;
        this.loanItems = loanItems;
        this.students = students;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LoanItems> getLoanItems() {
        return loanItems;
    }

    public void setLoanItems(List<LoanItems> loanItems) {
        this.loanItems = loanItems;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }


    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}

