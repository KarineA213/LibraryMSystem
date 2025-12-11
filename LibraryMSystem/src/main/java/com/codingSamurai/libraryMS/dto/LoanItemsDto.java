package com.codingSamurai.libraryMS.dto;

import com.codingSamurai.libraryMS.entities.Books;
import com.codingSamurai.libraryMS.entities.Loan;
import com.codingSamurai.libraryMS.entities.LoanItems;
import com.codingSamurai.libraryMS.entities.enums.Condition;
import com.codingSamurai.libraryMS.entities.enums.LoanStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LoanItemsDto {


    private Long bookId;
    private Long loanId;
    private String bookTitle;
    private String bookAuthor;
    private Condition conditionOnLoan;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime loanDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dueDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime returnDate;

    public LoanItemsDto() {
    }


    public LoanItemsDto(LoanItems entity) {

        loanId = entity.getLoan().getId();
        bookId = entity.getBook().getId();
        bookTitle = entity.getBook().getTitle();
        bookAuthor = entity.getBook().getAuthor();
        conditionOnLoan = entity.getConditionOnLoan();

        //datas

        loanDate = entity.getLoan().getLoanDate();
        dueDate = entity.getLoan().getDueDate();
        returnDate = entity.getLoan().getReturnDate();


    }

    public LoanItemsDto(Long bookId, Long loanId, String bookTitle, String bookAuthor, Condition conditionOnLoan, LocalDateTime loanDate, LocalDateTime dueDate, LocalDateTime returnDate) {
        this.bookId = bookId;
        this.loanId = loanId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.conditionOnLoan = conditionOnLoan;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
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

    public Condition getConditionOnLoan() {
        return conditionOnLoan;
    }

    public void setConditionOnLoan(Condition conditionOnLoan) {
        this.conditionOnLoan = conditionOnLoan;
    }
}