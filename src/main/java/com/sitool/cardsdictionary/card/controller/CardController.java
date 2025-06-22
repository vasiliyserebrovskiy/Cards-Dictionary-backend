package com.sitool.cardsdictionary.card.controller;

import com.sitool.cardsdictionary.card.dto.CardAddDto;
import com.sitool.cardsdictionary.card.dto.CardDto;
import com.sitool.cardsdictionary.card.dto.TranslationDeleteDto;
import com.sitool.cardsdictionary.card.dto.TranslationDto;
import com.sitool.cardsdictionary.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/word/add")
    public Boolean addCard(@RequestBody CardAddDto card) {
        return cardService.addCard(card);
    }

    @GetMapping("/word/{cardId}")
    public CardDto getCardById(@PathVariable Integer cardId) {
        return cardService.getCardById(cardId);
    }

    @GetMapping("/word/{name}")
    public CardDto getCardByName(@PathVariable String name) {
        return cardService.getCardByName(name);
    }

    @PatchMapping("/word/{cardId}")
    public CardDto updateCardById(@PathVariable Integer cardId, @RequestBody String name) {
        return cardService.updateCardById(cardId, name);
    }

    @PostMapping("/translation/word/{cardId}")
    public Boolean addTranslationById(@PathVariable Integer cardId, @RequestBody TranslationDto translation) {
        return cardService.addTranslationById(cardId, translation);
    }

    @PatchMapping("/translation/word/{cardId}")
    public Boolean updateTranslationById(@PathVariable Integer cardId, @RequestBody TranslationDto translation) {
        return cardService.updateTranslationById(cardId, translation);
    }

    @DeleteMapping("/translation/word/{cardId}")
    public Boolean deleteTranslationByCardId(@PathVariable Integer cardId, @RequestBody TranslationDeleteDto translation) {
        return cardService.deleteTranslationByCardId(cardId, translation);
    }

    @DeleteMapping("/word/{cardId}")
    public Boolean deleteCardById(@PathVariable Integer cardId) {
        return cardService.deleteCardById(cardId);
    }

    @GetMapping("/words")
    public List<CardDto> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/words/{number}")
    public List<CardDto> getRandomCards(@PathVariable Integer number) {
        return cardService.getRandomCards(number);
    }
}
