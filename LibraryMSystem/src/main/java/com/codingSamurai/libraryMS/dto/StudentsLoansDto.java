package com.codingSamurai.libraryMS.dto;

import com.codingSamurai.libraryMS.entities.LoanItems;
import com.codingSamurai.libraryMS.entities.enums.LoanStatus;

import java.time.LocalDateTime;

public class StudentsLoansDto {

//        private Long loanId;
//        private Long studentId;
        private String bookTitle;
        private String bookAuthor;
        private LocalDateTime loanDate;
        private  LocalDateTime dueDate;
        private  LocalDateTime returnDate;
        private LoanStatus status;

    public StudentsLoansDto() {
    }

    public StudentsLoansDto(Long loanId, Long studentId, String bookTitle, String bookAuthor, LocalDateTime loanDate, LocalDateTime dueDate, LocalDateTime returnDate, LoanStatus status) {
//        this.loanId = loanId;
//        this.studentId = studentId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public StudentsLoansDto(LoanItems entity) {
//        loanId = entity.getId();
        bookTitle = entity.getBook().getTitle();
        bookAuthor = entity.getBook().getAuthor();
        loanDate = entity.getLoan().getLoanDate();
        dueDate = entity.getLoan().getDueDate();
        returnDate = entity.getLoan().getReturnDate();
        status = entity.getLoan().getStatus();
    }



    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
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
