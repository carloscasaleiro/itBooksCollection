package com.cc.bookCollection.service;

import com.cc.bookCollection.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAll();

    Reservation save(Reservation reservation);

    List<Reservation> findByBookId(Integer bookId);
}
