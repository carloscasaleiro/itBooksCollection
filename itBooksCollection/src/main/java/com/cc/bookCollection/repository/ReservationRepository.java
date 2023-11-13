package com.cc.bookCollection.repository;

import com.cc.bookCollection.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByBookId(Integer bookId);
}
