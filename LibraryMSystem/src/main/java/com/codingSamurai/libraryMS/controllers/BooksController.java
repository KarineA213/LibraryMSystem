package com.codingSamurai.libraryMS.controllers;

import com.codingSamurai.libraryMS.dto.BooksDto;
import com.codingSamurai.libraryMS.entities.Books;
import com.codingSamurai.libraryMS.repositories.BooksRepository;
import com.codingSamurai.libraryMS.services.BooksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService service;
    @Autowired
    private BooksRepository booksRepository;
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping ("/{id}")
    //todo colocar pra que possa pesquisar partes do titulo e do author tb
    public ResponseEntity<BooksDto> findById(@PathVariable Long id) {

        BooksDto dto = service.findById(id);
        return ResponseEntity.ok(dto); //ok é o código 200

    }

    @GetMapping
    public ResponseEntity<Page<BooksDto>> findAll(
            @RequestParam(name = "title", defaultValue = "") String title,
            Pageable pageable) {
        Page<BooksDto> booksPage;
        if (title.isBlank()) {
            booksPage = service.findAll(pageable);
        }
        else {
            booksPage = service.findAllByName(title, pageable);
        }

        return ResponseEntity.ok(booksPage);
    }

//
//    @PostMapping
//    public ResponseEntity<BooksDto> insert(@Valid @RequestBody BooksDto booksDto) {
//        booksDto = service.insert(booksDto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(booksDto.getId()).toUri();
//        return ResponseEntity.created(uri).body(booksDto);
//
//    }


    //USAR OS DOIS DA ERRO
//    @GetMapping
//    public ResponseEntity<List<BooksDto>> findAllByName(
//            @RequestParam(name = "title", defaultValue = "") String title, Pageable pageable) {
//        Page<BooksDto> dto = service.findAllByName(title, pageable);
//        return ResponseEntity.ok(dto.getContent());
//
//    }
//
//
//    @GetMapping
//    public ResponseEntity<Page<BooksDto>> findAll(Pageable pageable) {
//        Page<BooksDto> books = (Page<BooksDto>) service.findAll(pageable);
//        return ResponseEntity.ok(books);
//
//    }





    @PostMapping
    public ResponseEntity<BooksDto> save(@Valid @RequestBody BooksDto books) {
        BooksDto savedBook =service.insert(books);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedBook);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BooksDto> update(@PathVariable Long id,@Valid @RequestBody BooksDto books) {
        books = service.update(id, books);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BooksDto> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

















}
