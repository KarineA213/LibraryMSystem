package com.codingSamurai.libraryMS.dto;

import com.codingSamurai.libraryMS.entities.Librarians;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LibrariansDto {

    private Long id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotNull
    private String password;

    public LibrariansDto(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public LibrariansDto(Long id) {
        this.id = id;
    }

    public LibrariansDto(Librarians entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
