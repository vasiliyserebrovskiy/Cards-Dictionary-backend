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
    @Column(name = "id")
    private long id;
    @Setter
    @Column(name = "code")
    private String code;
    @Setter
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "card_id")
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
