package com.sitool.cardsdictionary.card.service;

import com.sitool.cardsdictionary.card.dao.CardRepository;
import com.sitool.cardsdictionary.card.dto.*;
import com.sitool.cardsdictionary.card.dto.exceptions.NotFoundException;
import com.sitool.cardsdictionary.card.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public CardDto updateCardById(Long cardId, CardUpdateDto cardUpdateDto) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
        card.setName(cardUpdateDto.getName());
        cardRepository.save(card);
        return new CardDto(card.getId(), card.getName(), card.getTranslations());
    }
    //TODO: need to fix error: write null as key !
    @Override
    public Boolean addTranslationById(Long cardId, TranslationDto translation) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
        card.addTranslation(translation.getCode(), translation.getValue());
        cardRepository.save(card);
        return true; // TODO: need to think about this
    }

    @Override
    public Boolean updateTranslationById(Long cardId, TranslationDto translation) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
        card.updateTranslation(translation.getCode(), translation.getValue());
        cardRepository.save(card);
        return true; // TODO: need to think about this
    }

    @Override
    public Boolean deleteTranslationByCardId(Long cardId, TranslationDeleteDto translation) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
        card.removeTranslation(translation.getCode());
        cardRepository.save(card);
        return true; //TODO: need to think about this
    }

    @Override
    public CardDto deleteCardById(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
        cardRepository.deleteById(cardId);
        return new CardDto(card.getId(), card.getName(), card.getTranslations());
    }

    @Override
    public List<CardDto> getAllCards() {

        return cardRepository.findAll().stream().
                map(card -> new CardDto(card.getId(), card.getName(), card.getTranslations()))
                .toList();
    }

    @Override
    public List<CardDto> getRandomCards(Long number) {
        //TODO: Need to implement
        return null;
    }
}
