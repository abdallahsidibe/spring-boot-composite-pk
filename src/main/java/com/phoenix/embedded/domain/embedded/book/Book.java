package com.phoenix.embedded.domain.embedded.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private BookId bookId;
}
