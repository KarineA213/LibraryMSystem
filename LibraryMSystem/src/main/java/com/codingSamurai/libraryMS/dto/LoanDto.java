package com.codingSamurai.libraryMS.dto;

import com.codingSamurai.libraryMS.entities.Loan;
import com.codingSamurai.libraryMS.entities.Students;
import com.codingSamurai.libraryMS.entities.enums.Condition;
import com.codingSamurai.libraryMS.entities.enums.LoanStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
public class LoanDto {


    private Long id;

    private List<LoanItemsDto> loanItems;
    private LoanStudentsDto loanStudents;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private LoanStatus status;
//    private Condition conditionOnLoan;
//    private Condition conditionOnReturn;


    public LoanDto(Long id, List<LoanItemsDto> loanItems, LoanStudentsDto loanStudents, LocalDateTime loanDate, LocalDateTime dueDate, LocalDateTime returnDate, LoanStatus status) {
        this.id = id;
        this.loanItems = loanItems;
        this.loanStudents = loanStudents;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public LoanDto(Loan entity) {
        id = entity.getId();
        loanItems = entity.getLoanItems().stream().map(LoanItemsDto::new).collect(Collectors.toList());
        loanStudents = new LoanStudentsDto(entity.getStudents());
        loanDate = entity.getLoanDate();
        dueDate = entity.getDueDate();
        returnDate = entity.getReturnDate();
        status = entity.getStatus();
    }


//    public LoanDto(Loan entity) {
//
//        id = entity.getId();
//        loanItems = entity.getLoanItems().stream().map(LoanItemsDto::new).collect(Collectors.toList());
//        loanStudents = new LoanStudentsDto(entity.getStudents().getName().toUpperCase());
//        loanDate = entity.getLoanDate();
//        dueDate = entity.getDueDate();
//        returnDate = entity.getReturnDate();
//        status = entity.getStatus();
//
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LoanItemsDto> getLoanItems() {
        return loanItems;
    }

    public void setLoanItems(List<LoanItemsDto> loanItems) {
        this.loanItems = loanItems;
    }


    public LoanStudentsDto getLoanStudents() {
        return loanStudents;
    }

    public void setLoanStudents(LoanStudentsDto loanStudents) {
        this.loanStudents = loanStudents;
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