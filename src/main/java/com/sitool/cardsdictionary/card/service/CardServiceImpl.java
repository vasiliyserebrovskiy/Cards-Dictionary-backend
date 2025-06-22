package com.sitool.cardsdictionary.card.service;

import com.sitool.cardsdictionary.card.dto.CardAddDto;
import com.sitool.cardsdictionary.card.dto.CardDto;
import com.sitool.cardsdictionary.card.dto.TranslationDeleteDto;
import com.sitool.cardsdictionary.card.dto.TranslationDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CardServiceImpl implements CardService{
    @Override
    public Boolean addCard(CardAddDto card) {
        return null;
    }

    @Override
    public CardDto getCardById(Integer cardId) {
        return null;
    }

    @Override
    public CardDto getCardByName(String name) {
        return null;
    }

    @Override
    public CardDto updateCardById(Integer cardId, String name) {
        return null;
    }

    @Override
    public Boolean addTranslationById(Integer cardId, TranslationDto translation) {
        return null;
    }

    @Override
    public Boolean updateTranslationById(Integer cardId, TranslationDto translation) {
        return null;
    }

    @Override
    public Boolean deleteTranslationByCardId(Integer cardId, TranslationDeleteDto translation) {
        return null;
    }

    @Override
    public Boolean deleteCardById(Integer cardId) {
        return null;
    }

    @Override
    public List<CardDto> getAllCards() {
        return null;
    }

    @Override
    public List<CardDto> getRandomCards(Integer number) {
        return null;
    }
}
