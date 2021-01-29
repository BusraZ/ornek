package com.example.ornek.user;

import com.example.ornek.address.Address;
import com.example.ornek.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;

    @OneToOne(mappedBy = "user")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    public UserDto toUserDto() {
        return UserDto.builder()
                .id(this.id)
                .name(this.name)
                .surname(this.surname)
                .build();
    }
}
