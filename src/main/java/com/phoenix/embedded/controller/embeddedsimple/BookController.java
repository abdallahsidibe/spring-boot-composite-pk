package com.phoenix.embedded.controller.embeddedsimple;

import com.phoenix.embedded.domain.embeddedsimple.Book;
import com.phoenix.embedded.repository.embeddedsimple.BookRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books/{name}")
    public List<Book> getAllBooks(@PathVariable("name") String name){
        return bookRepository.findByIdName(name);
    }

    @GetMapping("/books/{name}")
    public List<Book> getAllBooks1(@RequestParam("name") String name){
        return bookRepository.findByIdName(name);
    }
    /**
     * @RequestParam est utilisé pour accéder aux paramètres de requête dans les requêtes Web.
     * @Param est utilisé pour accéder aux paramètres nommés dans les requêtes de référentiel.
     */
}
