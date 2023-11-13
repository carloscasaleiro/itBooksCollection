package com.cc.bookCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCollectionApplication.class, args);

		System.out.println("Loading Done");
	}
}
