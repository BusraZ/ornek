package com.example.ornek.author;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AuthorRepo extends CrudRepository<Author, UUID> {
}
