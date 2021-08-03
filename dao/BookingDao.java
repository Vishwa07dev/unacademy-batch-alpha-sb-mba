package com.vishwa.movieBookingSystem.dao;

import com.vishwa.movieBookingSystem.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingDao extends JpaRepository<Booking, Integer> {
}
