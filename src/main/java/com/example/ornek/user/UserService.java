package com.example.ornek.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public User create(User user){
        return userRepo.save(user);
    }
    public Page<User> list(PageRequest page){
        return userRepo.findAll(page);
    }
    public Optional<User> get(UUID id){
        return userRepo.findById(id);
    }
}
