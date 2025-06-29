package com.sitool.cardsdictionary.card.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString
@Entity
@Table(name = "translations")
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    private String code;
    @Setter
    private String value;
    @ManyToOne
    private Card card;

    public Translation(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public Translation(String code, String value, Card card) {
        this.code = code;
        this.value = value;
        this.card = card;
    }
}
