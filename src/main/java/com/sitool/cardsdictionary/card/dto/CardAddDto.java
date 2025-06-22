package com.sitool.cardsdictionary.card.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class CardAddDto {
    private String name;
    private Map<String, String> translations;
}
