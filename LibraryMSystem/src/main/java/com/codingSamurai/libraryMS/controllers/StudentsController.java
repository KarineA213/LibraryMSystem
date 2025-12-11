package com.codingSamurai.libraryMS.controllers;

import com.codingSamurai.libraryMS.dto.StudentInsertDto;
import com.codingSamurai.libraryMS.dto.StudentsDto;
import com.codingSamurai.libraryMS.entities.Students;
import com.codingSamurai.libraryMS.repositories.StudentsRepository;
import com.codingSamurai.libraryMS.services.StudentsService;
import com.codingSamurai.libraryMS.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;
    @Autowired
    private StudentsRepository studentsRepository;


    @GetMapping(value = "/{id}")
    ResponseEntity<StudentsDto> findById(@PathVariable Long id){
        StudentsDto dto = studentsService.findById(id);
        return ResponseEntity.ok(dto);
    }


    @GetMapping()
    public ResponseEntity<Page<StudentsDto>> findAll(Pageable pageable) {
        Page<StudentsDto> dto = studentsService.findAll(pageable);
        return ResponseEntity.ok(dto);

    }


    @PostMapping
    public ResponseEntity<StudentsDto> insert(@Valid @RequestBody StudentInsertDto insertDto) {
        StudentsDto createdDto = studentsService.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdDto.getId()).toUri();
        return ResponseEntity.created(uri).body(createdDto);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<StudentsDto> update(@PathVariable Long id, @Valid @RequestBody StudentsDto updateDto) {


        Students entity = studentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        StudentsDto updatedDto = studentsService.update(id, updateDto, entity);
        return ResponseEntity.ok(updatedDto);
    }




    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        studentsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//
//    @PostMapping
//    public ResponseEntity<StudentsDto> insert( @Valid @RequestBody StudentsDto dto) {
//        Students createdStudent = service.insert(dto);
//    }



}
