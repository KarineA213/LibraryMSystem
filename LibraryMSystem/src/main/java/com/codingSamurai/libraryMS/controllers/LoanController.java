package com.codingSamurai.libraryMS.controllers;

import com.codingSamurai.libraryMS.dto.LoanDto;
import com.codingSamurai.libraryMS.dto.LoanInsertDto;
import com.codingSamurai.libraryMS.entities.Loan;
import com.codingSamurai.libraryMS.services.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;


    @GetMapping("/{id}")
    public ResponseEntity<LoanDto> findById(@PathVariable Long id) {
        LoanDto dto = service.findById(id);
        return ResponseEntity.ok(dto); //cod 200
    }


    @GetMapping
    public ResponseEntity<Page<LoanDto>> findAll (Pageable pageable) {
        Page<LoanDto> loans = service.findAll(pageable);
        return ResponseEntity.ok(loans);
    }

    @PostMapping()
    public ResponseEntity<LoanDto> insert(@Valid @RequestBody LoanInsertDto loanInsertDto) {

        LoanDto createdLoanDto = service.insert(loanInsertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdLoanDto.getLoanId()).toUri();
                return ResponseEntity.created(uri).body(createdLoanDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LoanDto>  update(@PathVariable Long id, @Valid @RequestBody LoanDto loanDto) {
        LoanDto updatedDto = service.update(id, loanDto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LoanDto> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
