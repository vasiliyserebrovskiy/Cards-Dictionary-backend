package com.sitool.cardsdictionary.card.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CardAddDto {
    private String name;
    private List<TranslationDto> translations;
}
