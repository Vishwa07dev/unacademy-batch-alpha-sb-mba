package com.vishwa.movieBookingSystem.dao;

import com.vishwa.movieBookingSystem.entities.Language;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LanguageDao extends JpaRepository<Language, Integer> {
  public Optional<Language> findByLanguageName(String languageName);
}
