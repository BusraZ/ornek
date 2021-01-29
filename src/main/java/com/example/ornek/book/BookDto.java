package com.example.ornek.book;

import com.example.ornek.author.AuthorDto;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
public class BookDto {

    private UUID id;
    private String name;
    @Min(value = 1, message = "Book price cannot be lower than 1 Euro")
    private double price;
   private Set<AuthorDto> authorDtoSet;

   public Book toBook(){
       return Book.builder().id(this.id).name(this.name).price(this.price)
               .authors(authorDtoSet.stream()
                       .map(AuthorDto::toAuthor).collect(Collectors.toSet())).build();
   }
}
