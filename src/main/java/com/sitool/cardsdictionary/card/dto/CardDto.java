package com.sitool.cardsdictionary.card.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Long id;
    private String name;
    private Map<String, String> translations;
}
