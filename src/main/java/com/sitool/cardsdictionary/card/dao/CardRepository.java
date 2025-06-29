package com.sitool.cardsdictionary.card.dao;

import com.sitool.cardsdictionary.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
