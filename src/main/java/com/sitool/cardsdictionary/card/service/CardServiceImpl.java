package com.sitool.cardsdictionary.card.service;

import com.sitool.cardsdictionary.card.dao.CardRepository;
import com.sitool.cardsdictionary.card.dto.CardAddDto;
import com.sitool.cardsdictionary.card.dto.CardDto;
import com.sitool.cardsdictionary.card.dto.TranslationDeleteDto;
import com.sitool.cardsdictionary.card.dto.TranslationDto;
import com.sitool.cardsdictionary.card.dto.exceptions.NotFoundException;
import com.sitool.cardsdictionary.card.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Boolean addCard(CardAddDto card) {
        if(cardRepository.findByName(card.getName()).isPresent()) {
            return false;
        }
        Card newCard = new Card(card.getName(), card.getTranslations());
        cardRepository.save(newCard);
        return true;
    }

    @Override
    public CardDto getCardById(Long cardId) {
        Card card =  cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
        return new CardDto(card.getId(), card.getName(), card.getTranslations());
    }

    @Override
    public CardDto getCardByName(String name) {
        Card card =  cardRepository.findByName(name).orElseThrow(NotFoundException::new);
        return new CardDto(card.getId(), card.getName(), card.getTranslations());
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
