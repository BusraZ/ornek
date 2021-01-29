package com.example.ornek.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface BookRepo extends CrudRepository<Book, UUID> {
    Page<Book> findAll(Pageable page);
    Page<Book> findAllByAuthors_NameContainingIgnoreCase(String name,Pageable pageable);
}
