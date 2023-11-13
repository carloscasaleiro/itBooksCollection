package com.cc.bookCollection.repository;

import com.cc.bookCollection.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "books")
public interface BookCollectionRepository extends JpaRepository<Book, Integer> {
}
