package com.cc.bookCollection.service;

import com.cc.bookCollection.model.Book;
import com.cc.bookCollection.repository.BookCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookCollectionRepository bookCollectionRepository;

    @Autowired
    public BookServiceImpl(BookCollectionRepository bookCollectionRepository) {
        this.bookCollectionRepository = bookCollectionRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookCollectionRepository.findAll();
    }

    @Override
    public List<Book> findAllByOrderByTitleAsc() {
        return bookCollectionRepository.findAll(Sort.by("Title").ascending());
    }

    @Override
    public List<Book> findAllByOrderByTitleDesc() {
        return bookCollectionRepository.findAll(Sort.by("Title").descending());
    }

    @Override
    public Book save(Book book) {
        return bookCollectionRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {

        Optional<Book> optionalBook = bookCollectionRepository.findById(id);

        Book book;

        if(optionalBook.isPresent()) {
            book = optionalBook.get();
        } else {
            throw new RuntimeException("Book with id " + id + " not found!");
        }
        return book;
    }

    @Override
    public void deleteById(Integer id) {
        bookCollectionRepository.deleteById(id);
    }

}
