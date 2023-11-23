package com.phoenix.embedded.domain.embeddedsimple;


import com.phoenix.embedded.domain.embeddedsimple.BookId;
import com.phoenix.embedded.repository.embeddedsimple.BookRepository;
import jakarta.persistence.EmbeddedId;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Book {
    @EmbeddedId
    private BookId id;
    private String genre;
    private Integer price;
}
