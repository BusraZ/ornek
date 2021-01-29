package com.example.ornek.order;

import com.example.ornek.book.Book;
import com.example.ornek.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime createdAt;
    private double total;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @ManyToMany
    @JoinTable( joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "id"),
                  inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"))
    private List<Book> books;
}
