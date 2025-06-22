package com.sitool.cardsdictionary.card.service;

import com.sitool.cardsdictionary.card.dto.CardAddDto;
import com.sitool.cardsdictionary.card.dto.CardDto;
import com.sitool.cardsdictionary.card.dto.TranslationDeleteDto;
import com.sitool.cardsdictionary.card.dto.TranslationDto;

import java.util.List;

public interface CardService {

    Boolean addCard(CardAddDto card);

    CardDto getCardById(Integer cardId);

    CardDto getCardByName(String name);

    CardDto updateCardById(Integer cardId, String name);

    Boolean addTranslationById(Integer cardId, TranslationDto translation);

    Boolean updateTranslationById(Integer cardId, TranslationDto translation);

    Boolean deleteTranslationByCardId(Integer cardId, TranslationDeleteDto translation);

    Boolean deleteCardById(Integer cardId);

    List<CardDto> getAllCards();

    List<CardDto> getRandomCards(Integer number);


}
