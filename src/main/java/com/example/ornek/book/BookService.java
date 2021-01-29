package com.example.ornek.book;

import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class BookService {
    private BookRepo bookRepo;
    public BookService(BookRepo bookRepo){
        this.bookRepo=bookRepo;
    }
    public Book create(Book book){
        return bookRepo.save(book);
    }
    public Page<Book> list(Pageable pageable){
        return bookRepo.findAll(pageable);
    }
    public Page<Book> list(String author,Pageable pageable){
        return bookRepo.findAllByAuthors_NameContainingIgnoreCase(author, pageable);
    }
}
