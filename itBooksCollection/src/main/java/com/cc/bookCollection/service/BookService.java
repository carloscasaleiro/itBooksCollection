package com.cc.bookCollection.service;

import com.cc.bookCollection.model.Book;
import java.util.List;

public interface BookService {

    List<Book> findAll();
    List<Book> findAllByOrderByTitleAsc();
    List<Book> findAllByOrderByTitleDesc();

    Book save(Book book);

    Book findById(Integer id);

    void deleteById(Integer id);
}
