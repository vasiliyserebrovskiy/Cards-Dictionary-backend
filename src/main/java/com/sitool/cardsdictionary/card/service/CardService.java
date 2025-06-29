package com.sitool.cardsdictionary.card.service;

import com.sitool.cardsdictionary.card.dto.*;
import com.sitool.cardsdictionary.card.model.Card;

import java.util.List;

public interface CardService {

    CardDto addCard(CardAddDto card);

    CardDto getCardById(Long cardId);

    CardDto getCardByName(String name);

    CardDto updateCardById(Long cardId, CardUpdateDto name);

    CardDto addTranslationById(Long cardId, TranslationDto translation);

    Boolean updateTranslationById(Long cardId, TranslationDto translation);

    Boolean deleteTranslationByCardId(Long cardId, TranslationDeleteDto translation);

    CardDto deleteCardById(Long cardId);

    List<CardDto> getAllCards();

    List<CardDto> getRandomCards(Long number);


}
