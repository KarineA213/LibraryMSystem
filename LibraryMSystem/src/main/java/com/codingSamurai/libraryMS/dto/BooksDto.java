package com.codingSamurai.libraryMS.dto;

import com.codingSamurai.libraryMS.entities.Books;
import com.codingSamurai.libraryMS.entities.Loan;
import com.codingSamurai.libraryMS.entities.LoanItems;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;


public class BooksDto {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank
        private String title;
        @NotBlank
        private String author;
        @NotBlank
        private String publisher;
        @NotBlank
        private String isbn;
        @NotNull
        private Integer publicationYear;
        @NotNull
        private Integer copies;

//    private List<LoanItems> loansItems;

    public BooksDto() {
    }

    public BooksDto(Long id, String title, String author, String publisher, String isbn, int publicationYear, int copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.copies = copies;

    }



    public BooksDto(Books entity) {

            id = entity.getId();
            title = entity.getTitle();
            author = entity.getAuthor();
            publisher = entity.getPublisher();
            isbn = entity.getIsbn();
            publicationYear = entity.getPublicationYear();
            copies = entity.getCopies();
        }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getCopies() {
        return copies;
    }


}
