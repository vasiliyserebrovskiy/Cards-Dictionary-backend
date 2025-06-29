package com.sitool.cardsdictionary.card.dao;

import com.sitool.cardsdictionary.card.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation,Long> {
}
