package com.codingSamurai.libraryMS.repositories;

import com.codingSamurai.libraryMS.entities.Books;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;


public interface BooksRepository extends JpaRepository<Books, Long> {



//    List<Books> findById(SingularAttribute<AbstractPersistable, Serializable> id);

@Query("SELECT obj FROM Books obj WHERE UPPER(obj.title) LIKE UPPER(CONCAT('%', :title, '%'))")
    Page<Books> searchBooks(@Param("title") String title, Pageable pageable);

}


