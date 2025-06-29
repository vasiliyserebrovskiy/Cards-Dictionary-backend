package com.sitool.cardsdictionary.card.service;

import com.sitool.cardsdictionary.card.dao.CardRepository;
import com.sitool.cardsdictionary.card.dto.*;
import com.sitool.cardsdictionary.card.dto.exceptions.NotFoundException;
import com.sitool.cardsdictionary.card.model.Card;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    private final ModelMapper modelMapper;


    @Override
    public CardDto addCard(CardAddDto card) {
        return null;
    }

    @Override
    public CardDto getCardById(Long cardId) {
        return null;
    }

    @Override
    public CardDto getCardByName(String name) {
        return null;
    }

    @Override
    public CardDto updateCardById(Long cardId, CardUpdateDto name) {
        return null;
    }

    @Override
    public Boolean addTranslationById(Long cardId, TranslationDto translation) {
        return null;
    }

    @Override
    public Boolean updateTranslationById(Long cardId, TranslationDto translation) {
        return null;
    }

    @Override
    public Boolean deleteTranslationByCardId(Long cardId, TranslationDeleteDto translation) {
        return null;
    }

    @Override
    public CardDto deleteCardById(Long cardId) {
        return null;
    }

    @Override
    public List<CardDto> getAllCards() {
        return List.of();
    }

    @Override
    public List<CardDto> getRandomCards(Long number) {
        return List.of();
    }
}
