package com.sitool.cardsdictionary.card.dao;

import com.sitool.cardsdictionary.card.model.Card;

import java.util.List;
import java.util.Optional;

public interface CardRepository {

    Card save(Card card);

    Optional<Card> findById(Long id);

    Optional<Card> findByName(String name);

    void deleteById(Long id);

    List<Card> findAll();

    List<Card> getNumbersOfCards(Integer number);
}
