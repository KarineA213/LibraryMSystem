package com.codingSamurai.libraryMS.services;

import com.codingSamurai.libraryMS.dto.StudentInsertDto;
import com.codingSamurai.libraryMS.dto.StudentsDto;
import com.codingSamurai.libraryMS.entities.Students;
import com.codingSamurai.libraryMS.repositories.StudentsRepository;
import com.codingSamurai.libraryMS.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository repository;


    @Transactional
    public StudentsDto findById(Long id) {
        Students students = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not found with id " + id));

        return new StudentsDto(students);
    }


    @Transactional
    public Page<StudentsDto> findAll(Pageable pageable) {
        Page<Students> studentsPage = repository.findAll(pageable);
        return studentsPage.map(x -> new StudentsDto(x));
    }

//    @Transactional
//    public StudentsDto insert(StudentsDto studentsDto) {
//        Students entity = new Students();
//        copyDtoToEntity(studentsDto, entity);
//        entity = repository.save(entity);
//        return new StudentsDto(entity);
//
//    }

    @Transactional
    public StudentsDto insert(StudentInsertDto insertDto) {
        Students students = new Students();
        copyDtoToEntityInsert(insertDto, students);
        students = repository.save(students);
        return new StudentsDto(students);

    }


    @Transactional
    public StudentsDto update(Long id, StudentsDto studentsDto, Students entity) {

        try {
            copyDtoToEntity(studentsDto, entity);
            entity = repository.save(entity);
            return new StudentsDto(entity);


        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
    }


    @Transactional
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Falha na integridade referencial");
        }
    }

    private void copyDtoToEntity(StudentsDto studentsDto, Students entity) {
        entity.setName(studentsDto.getName());
        entity.setEmail(studentsDto.getEmail());
        entity.setPhone(studentsDto.getPhone());
        entity.setCourse(studentsDto.getCourse());
    }

    private void copyDtoToEntityInsert(StudentInsertDto insertDto, Students entity) {
        entity.setName(insertDto.getName());
        entity.setEmail(insertDto.getEmail());
        entity.setPhone(insertDto.getPhone());
        entity.setCourse(insertDto.getCourse());
    }



}
