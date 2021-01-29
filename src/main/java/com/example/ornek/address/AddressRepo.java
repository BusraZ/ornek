package com.example.ornek.address;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepo extends CrudRepository<Address, UUID> {
}
