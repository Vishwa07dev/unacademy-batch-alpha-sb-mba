package com.vishwa.movieBookingSystem.dao;

import com.vishwa.movieBookingSystem.entities.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieTheatreDao extends JpaRepository<MovieTheatre, Integer> {
}
