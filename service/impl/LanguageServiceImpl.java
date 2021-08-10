package com.vishwa.movieBookingSystem.service.impl;

import com.vishwa.movieBookingSystem.dao.LanguageDao;
import com.vishwa.movieBookingSystem.entities.Language;
import com.vishwa.movieBookingSystem.exceptions.LanguageDetailsNotFoundException;
import com.vishwa.movieBookingSystem.service.LanguageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LanguageServiceImpl implements LanguageService {

  @Autowired
  private LanguageDao languageDao;

  @Override
  public Language acceptLanguageDetails(Language language) {
    return languageDao.save(language);
  }

  @Override
  public Language getLanguageDetails(int id) throws LanguageDetailsNotFoundException {
    return languageDao.findById(id)
        .orElseThrow(
            () -> new LanguageDetailsNotFoundException("Language not found by id: " + id)
        );
  }

  @Override
  public Language getLanguageDetailsByLanguageName(String languageName) throws LanguageDetailsNotFoundException {
    return languageDao.findByLanguageName(languageName)
        .orElseThrow(
            () -> new LanguageDetailsNotFoundException("Language not found by languageName: " + languageName)
        );
  }

  @Override
  public boolean deleteLanguage(int id) throws LanguageDetailsNotFoundException {
    Language language = getLanguageDetails(id);
    languageDao.delete(language);
    return true;
  }

  @Override
  public List<Language> getAllLanguageDetails() {
    return languageDao.findAll();
  }
}