package com.sitool.cardsdictionary.card.dao;

import com.sitool.cardsdictionary.card.model.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CardRepositoryImpl implements CardRepository {

    private static final Map<Long, Card> cards = new ConcurrentHashMap<>();

    @Override
    public Card save(Card card) {
        cards.put(card.getId(), card);
        return card;
    }

    @Override
    public Optional<Card> findById(Long id) {
        return Optional.ofNullable(cards.get(id));
    }

    @Override
    public Optional<Card> findByName(String name) {
        return Optional.ofNullable(cards.values().stream()
                .filter(card -> card.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null)
        );
    }

    @Override
    public void deleteById(Long id) {
        cards.remove(id);
    }

    @Override
    public List<Card> findAll() {
        return new ArrayList<>(cards.values());
    }

    @Override
    public List<Card> getNumbersOfCards(Integer number) {
        return List.of();
    }
}
