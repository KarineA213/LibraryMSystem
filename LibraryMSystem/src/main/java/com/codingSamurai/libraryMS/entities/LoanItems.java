package com.codingSamurai.libraryMS.entities;


import com.codingSamurai.libraryMS.dto.LoanItemsDto;
import com.codingSamurai.libraryMS.entities.enums.Condition;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.EnumMap;


@Entity
public class LoanItems  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "books_id")
    private Books book;

    @Enumerated(EnumType.STRING)
    private Condition conditionOnLoan;

    @Enumerated(EnumType.STRING)
    private Condition conditionOnReturn;



    public LoanItems() {
    }

    public LoanItems(Long id, Loan loan, Books book, Condition conditionOnLoan, Condition conditionOnReturn) {
        this.id = id;
//        this.loan = loan;
        this.book = book;
        this.conditionOnLoan = conditionOnLoan;
        this.conditionOnReturn = conditionOnReturn;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Condition getConditionOnLoan() {
        return conditionOnLoan;
    }

    public void setConditionOnLoan(Condition conditionOnLoan) {
        this.conditionOnLoan = conditionOnLoan;
    }

    public Condition getConditionOnReturn() {
        return conditionOnReturn;
    }

    public void setConditionOnReturn(Condition conditionOnReturn) {
        this.conditionOnReturn = conditionOnReturn;
    }


}

