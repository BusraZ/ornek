package com.example.ornek.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface UserRepo extends CrudRepository<User, UUID> {
    Page<User> findAll(Pageable page);
}
