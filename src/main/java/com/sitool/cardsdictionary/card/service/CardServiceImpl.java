package com.sitool.cardsdictionary.card.service;

import com.sitool.cardsdictionary.card.dao.CardRepository;
import com.sitool.cardsdictionary.card.dao.TranslationRepository;
import com.sitool.cardsdictionary.card.dto.*;
import com.sitool.cardsdictionary.card.dto.exceptions.NotFoundException;
import com.sitool.cardsdictionary.card.dto.exceptions.TransalationAlreadyExistsException;
import com.sitool.cardsdictionary.card.dto.exceptions.WordAlreadyExistsException;
import com.sitool.cardsdictionary.card.model.Card;
import com.sitool.cardsdictionary.card.model.Translation;
import org.springframework.transaction.annotation.Transactional;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final TranslationRepository translationRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public CardDto addCard(CardAddDto card) {

        Optional<Card> cardExist = cardRepository.findByNameIgnoreCase(card.getName());

        if (cardExist.isPresent()) {
            throw new WordAlreadyExistsException("Word already exists: " + card.getName());
        }

        Card newCard = new Card(card.getName());

        if (!card.getTranslations().isEmpty()) {
            for (TranslationDto translation : card.getTranslations()) {
                Translation newTranslation = new Translation(translation.getCode(), translation.getValue(), newCard);
                newCard.addTranslation(newTranslation);
                translationRepository.save(newTranslation);
            }
        }

        newCard = cardRepository.save(newCard);

        return modelMapper.map(newCard, CardDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public CardDto getCardById(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
        return modelMapper.map(card, CardDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public CardDto getCardByName(String name) {
        Card card = cardRepository.findByNameIgnoreCase(name).orElseThrow(NotFoundException::new);
        return modelMapper.map(card, CardDto.class);
    }

    @Override
    @Transactional
    public CardDto updateCardById(Long cardId, CardUpdateDto name) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
        card.setName(name.getName());
        return modelMapper.map(card, CardDto.class);
    }

    @Override
    @Transactional
    public CardDto addTranslationById(Long cardId, TranslationDto translation) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);


        if (card.hasTranslationWithCode(translation.getCode())) {
            throw new TransalationAlreadyExistsException("Translation " + translation.getCode() + " already exists: " + translation.getValue());
        }

        Translation newTranslation = new Translation(translation.getCode(), translation.getValue(), card);
        card.addTranslation(newTranslation);
        translationRepository.save(newTranslation);
        return modelMapper.map(card, CardDto.class);
    }

    @Override
    @Transactional
    public CardDto updateTranslationById(Long cardId, TranslationDto translation) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);

        Translation translationToChange = card.getTranslations().stream()
                .filter(trCode -> trCode.getCode().equals(translation.getCode()))
                .findFirst().orElseThrow(NotFoundException::new);

        translationToChange.setValue(translation.getValue());
        return modelMapper.map(card, CardDto.class);
    }

    @Override
    @Transactional
    public CardDto deleteTranslationByCardId(Long cardId, TranslationDeleteDto translation) {

        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
        Translation translationToRemove = card.getTranslations().stream()
                .filter(trCode -> trCode.getCode().equals(translation.getCode()))
                .findFirst().orElseThrow(NotFoundException::new);

        translationRepository.delete(translationToRemove);
        card.removeTranslation(translationToRemove);
        return modelMapper.map(card, CardDto.class);
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
