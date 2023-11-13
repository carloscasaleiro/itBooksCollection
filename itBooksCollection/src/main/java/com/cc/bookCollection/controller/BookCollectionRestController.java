package com.cc.bookCollection.controller;

import com.cc.bookCollection.model.Book;
import com.cc.bookCollection.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookCollectionRestController {

    private BookService bookService;

    @Autowired
    public BookCollectionRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books/A-Z")
    public List<Book> findAllByOrderByTitleAsc() {
        return bookService.findAllByOrderByTitleAsc();
    }

    @GetMapping("books/Z-A")
    public List<Book> findAllByOrderByTitleDesc() {
        return bookService.findAllByOrderByTitleDesc();
    }
}
