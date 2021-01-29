package com.example.ornek.order;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepo extends CrudRepository<Orders, UUID> {
}
