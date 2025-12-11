package com.codingSamurai.libraryMS.repositories;

import com.codingSamurai.libraryMS.dto.StudentsDto;
import com.codingSamurai.libraryMS.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {


}