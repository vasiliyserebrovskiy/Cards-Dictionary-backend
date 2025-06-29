package com.sitool.cardsdictionary.card.dao;

import com.sitool.cardsdictionary.card.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TranslationRepository extends JpaRepository<Translation,Long> {
    Optional<Translation> findByCode(String code);
}
