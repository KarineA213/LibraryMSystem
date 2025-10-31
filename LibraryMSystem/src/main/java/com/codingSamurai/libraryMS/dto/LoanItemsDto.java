package com.codingSamurai.libraryMS.dto;

import com.codingSamurai.libraryMS.entities.Books;
import com.codingSamurai.libraryMS.entities.Loan;
import com.codingSamurai.libraryMS.entities.LoanItems;
import com.codingSamurai.libraryMS.entities.enums.Condition;

public class LoanItemsDto {


    private Long bookId;
    private Long loanId;
    private String bookTitle;
    private String bookAuthor;

    public LoanItemsDto() {
    }

    public LoanItemsDto( Long loanId, Long bookId, String bookTitle, String bookAuthor) {

        this.loanId = loanId;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;

    }

    public LoanItemsDto(LoanItems entity) {
//        this.id = entity.getId();
        this.loanId = entity.getLoan().getId();
        this.bookId = entity.getBook().getId();
        this.bookTitle = entity.getBook().getTitle();
        this.bookAuthor = entity.getBook().getAuthor();

    }




    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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
}