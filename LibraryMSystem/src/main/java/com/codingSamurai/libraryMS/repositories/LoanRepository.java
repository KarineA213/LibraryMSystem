package com.codingSamurai.libraryMS.repositories;

import com.codingSamurai.libraryMS.entities.Loan;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

//    Loan getReferenceById(SingularAttribute<AbstractPersistable, Serializable> id);
}
