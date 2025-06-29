package com.sitool.cardsdictionary.card.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Setter
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true) //mappedBy in parrententry
    private List<Translation> translations = new ArrayList<>();

    public Card(String name) {
        this.name = name;
    }

    public void addTranslation(Translation translation) {
        translations.add(translation);
    }

    public void removeTranslation(Translation translation) {
        translations.remove(translation);
    }

    public boolean hasTranslationWithCode(String code) {
        return translations.stream()
                .anyMatch(t -> t.getCode().equals(code));
    }
}
