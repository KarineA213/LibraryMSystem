package com.codingSamurai.libraryMS.services;

import com.codingSamurai.libraryMS.dto.LoanDto;
import com.codingSamurai.libraryMS.dto.LoanInsertDto;
import com.codingSamurai.libraryMS.dto.LoanItemsDto;
import com.codingSamurai.libraryMS.entities.Books;
import com.codingSamurai.libraryMS.entities.Loan;
import com.codingSamurai.libraryMS.entities.LoanItems;
import com.codingSamurai.libraryMS.entities.Students;
import com.codingSamurai.libraryMS.repositories.BooksRepository;
import com.codingSamurai.libraryMS.repositories.LoanRepository;
import com.codingSamurai.libraryMS.repositories.StudentsRepository;
import com.codingSamurai.libraryMS.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Use este Transactional

import java.time.LocalDateTime;
import java.util.Optional;
// import org.springframework.transaction.annotation.Propagation; // Não é necessário aqui


@Service
public class LoanService {


    @Autowired
    private LoanRepository repository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Transactional(readOnly = true)
    public LoanDto findById(long id) {
        Loan entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found with id " + id)
        );
        return new LoanDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<LoanDto> findAll(Pageable pageable) {
        Page<Loan> result = repository.findAll(pageable);
        return result.map(LoanDto::new);
    }

    @Transactional
    public LoanDto insert(LoanInsertDto dto) {

        Loan entity = new Loan();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new LoanDto(entity);
    }

    @Transactional
    public LoanDto update(Long id, LoanDto dto) {
        try {
            Loan entity = repository.getReferenceById(id);
            copyUpdateDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new LoanDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found with id " + id);
        }
    }

    private void copyUpdateDtoToEntity(LoanDto dto, Loan entity) {

        entity.setLoanDate(LocalDateTime.now());
        entity.setDueDate(dto.getDueDate());
        entity.setReturnDate(dto.getReturnDate());
        entity.setStatus(dto.getStatus());

    }

    private void copyDtoToEntity(LoanInsertDto dto, Loan entity) {


//        entity.setStudent(dto.getStudent().toEntity());

        Optional<Students> students  = studentsRepository.findById(dto.getStudentsId());
        entity.setLoanDate(LocalDateTime.now());
        entity.setStatus(null);
        entity.setReturnDate(null);
        entity.setDueDate(dto.getDueDate());

        if (dto.getLoanItems() != null) {
            for (LoanItemsDto itemDto : dto.getLoanItems()) {

                LoanItems loanItem = new LoanItems();
                Books book = booksRepository.findById(itemDto.getBookId()) // Assumindo que LoanItemsDto tem getBookId()
                        .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + itemDto.getBookId()));

                if (book.getCopies() <= 0){
                    throw new ResourceNotFoundException("Book copies less than 0");
                }

                book.setCopies(book.getCopies()-1);
                booksRepository.save(book);
                loanItem.setBook(book);
                loanItem.setLoan(entity);
                entity.getLoanItems().add(loanItem);
            }
        }
    }



    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found with id " + id);
        }
        repository.deleteById(id);
    }
}