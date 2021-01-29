package com.example.ornek.author;

import com.example.ornek.book.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
    public AuthorDto toAuthorDto(){
        return AuthorDto.builder().id(this.id).name(this.name).build();
    }
}
