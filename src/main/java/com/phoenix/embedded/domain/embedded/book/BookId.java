package com.phoenix.embedded.domain.embedded.book;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BookId implements Serializable {
    private String title;
    private String language;
}
