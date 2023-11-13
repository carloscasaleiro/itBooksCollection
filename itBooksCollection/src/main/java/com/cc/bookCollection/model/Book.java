package com.cc.bookCollection.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    private Integer yearPublished;

    private String isbn;

    private String imageUrl;

    private String description;
}
