package com.cc.bookCollection.controller;

import com.cc.bookCollection.model.Book;
import com.cc.bookCollection.model.Reservation;
import com.cc.bookCollection.service.BookService;
import com.cc.bookCollection.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookCollectionController {

    private BookService bookService;
    private ReservationService reservationService;

    @Autowired
    public BookCollectionController(BookService bookService, ReservationService reservationService) {
        this.bookService = bookService;
        this.reservationService = reservationService;
    }

    @GetMapping("/list")
    public String listBooks(Model model) {

        List<Book> bookList = bookService.findAll();

        List<Reservation> reservationList = reservationService.findAll();

        List<Integer> reservedBooks = reservationList.stream()
                .filter(Reservation::getReserved)
                .map(reservation -> reservation.getBook().getId())
                .collect(Collectors.toList());

        model.addAttribute("book_list", bookList);

        model.addAttribute("reserved_books", reservedBooks);

        return "book_list.html";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Book book = new Book();

        model.addAttribute("book", book);

        return "book_form.html";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {

        bookService.save(book);

        return "redirect:/books/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int id, Model model) {

        Book book = bookService.findById(id);

        model.addAttribute("book", book);

        return "book_form.html";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int id) {

        bookService.deleteById(id);

        return "redirect:/books/list";
    }

    @GetMapping("/reserveBook")
    public String reserveBook(@RequestParam("bookId") int id) {

        Book book = bookService.findById(id);

        Reservation reservation = new Reservation();
        reservation.setBook(book);
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setReserved(true);

        reservationService.save(reservation);

        return "redirect:/books/list";
    }

    @GetMapping("/returnBook")
    public String returnBook(@RequestParam("bookId") int id) {

        List<Reservation> reservationList = reservationService.findByBookId(id);

        reservationList.stream()
                .peek(reservation -> reservation.setReserved(false))
                .peek(reservation -> reservation.setReturnDate(LocalDateTime.now()))
                .forEach(reservationService::save);

        return "redirect:/books/list";
    }
}
