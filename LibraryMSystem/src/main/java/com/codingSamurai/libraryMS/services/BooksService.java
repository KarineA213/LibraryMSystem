package com.codingSamurai.libraryMS.services;

import com.codingSamurai.libraryMS.dto.BooksDto;
import com.codingSamurai.libraryMS.entities.Books;
import com.codingSamurai.libraryMS.repositories.BooksRepository;
import com.codingSamurai.libraryMS.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
public class BooksService {

    @Autowired
    BooksRepository repository;


    @Transactional
    public BooksDto findById(Long id){
        Books entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Identificador não encontrado"));
        return new BooksDto(entity);
        //  .orElseThrow(EntityNotFoundException::new);
    }

//    public BooksDto findById (Long id){
//        Optional<Books> books = repository.findById(id);
//        return (BooksDto) books.stream()
//                .map(book -> new BooksDto(book))
//                .collect(Collectors.toList());
//    }

    @Transactional
     public Page<BooksDto> findAllByName(String title, Pageable pageable){
        Page<Books> result = repository.searchBooks(title, pageable);
        return result.map(BooksDto::new);
    }

    @Transactional
    public Page <BooksDto> findAll (Pageable pageable){
        Page<Books> books = repository.findAll(pageable);
        return  books.map(book -> new BooksDto(book));
    }

    @Transactional
    public BooksDto insert (BooksDto books){
        Books book = new Books();
        copyDtoToEntity(books, book);
        Books savedBook = repository.save(book);
        return new BooksDto(savedBook);



    }

    @Transactional
    public BooksDto update ( Long id, BooksDto books){
        try {
            Books entity = repository.getReferenceById(id);

            copyDtoToEntity(books, entity);

            entity = repository.save(entity);
            return new BooksDto(entity);

        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found");
        }

    }

    @Transactional
    public void delete ( Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found");
        }
            repository.deleteById(id);

    }


    private void copyDtoToEntity(BooksDto source, Books target) {

        target.setTitle(source.getTitle());
        target.setAuthor(source.getAuthor());
        target.setIsbn(source.getIsbn());
        target.setPublicationYear(source.getPublicationYear());
        target.setPublisher(source.getPublisher());
        target.setCopies(source.getCopies());
    }



}
