package com.sitool.cardsdictionary.card.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@EqualsAndHashCode(of = {"id", "name"})
public class Card {
    private static final AtomicInteger counter = new AtomicInteger(0); // for card id generation
    private final long id;
    @Setter
    private String name;
    private Map<String, String> translations = new HashMap<>();

    public Card(String name) {
        this.id = counter.incrementAndGet();
        this.name = name;
    }

    public Card(String name, Map<String, String> translations) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.translations = translations;
    }

    public boolean addTranslation(String languageCode, String value) {
        return translations.put(languageCode, value) == null;
    }

    public String updateTranslation(String languageCode, String value) {
        return translations.put(languageCode, value);
    }

    public boolean removeTranslation(String languageCode) {
        return translations.remove(languageCode) == null;
    }
}
