package com.example.ornek.book;

import com.example.ornek.author.Author;
import com.example.ornek.order.Orders;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private double price;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable( joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"),
                 inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Set<Author> authors;
    @ManyToMany(mappedBy = "books")
    private List<Orders> orders;
    public BookDto toBookDto(){
        return BookDto.builder().id(this.id).name(this.name).price(this.price)
                .authorDtoSet(authors.stream()
                        .map(Author::toAuthorDto).collect(Collectors.toSet())).build();
    }

}
