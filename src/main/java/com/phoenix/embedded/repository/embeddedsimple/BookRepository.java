package com.phoenix.embedded.repository.embeddedsimple;

import com.phoenix.embedded.domain.embeddedsimple.Book;
import com.phoenix.embedded.domain.embeddedsimple.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, BookId> {
    List<Book> findByIdName(String name);
    List<Book> findByIdAuthor(String author);
}
