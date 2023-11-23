package com.phoenix.embedded.domain.embeddedsimple;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class BookId implements Serializable {
    private String author;
    private String name;
}
