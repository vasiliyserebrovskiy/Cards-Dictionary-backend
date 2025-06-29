package com.sitool.cardsdictionary.card.controller;

import com.sitool.cardsdictionary.card.dto.*;
import com.sitool.cardsdictionary.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/word/add")
    public CardDto addCard(@RequestBody CardAddDto card) {
        return cardService.addCard(card);
    }

    @GetMapping("/word/id/{cardId}")
    public CardDto getCardById(@PathVariable Long cardId) {
        return cardService.getCardById(cardId);
    }

    @GetMapping("/word/name/{name}")
    public CardDto getCardByName(@PathVariable String name) {
        return cardService.getCardByName(name);
    }

    @PatchMapping("/word/{cardId}")
    public CardDto updateCardById(@PathVariable Long cardId, @RequestBody CardUpdateDto name) {
        return cardService.updateCardById(cardId, name);
    }

    @PostMapping("/translation/word/{cardId}")
    public CardDto addTranslationById(@PathVariable Long cardId, @RequestBody TranslationDto translation) {
        return cardService.addTranslationById(cardId, translation);
    }

    @PatchMapping("/translation/word/{cardId}")
    public CardDto updateTranslationById(@PathVariable Long cardId, @RequestBody TranslationDto translation) {
        return cardService.updateTranslationById(cardId, translation);
    }

    @DeleteMapping("/translation/word/{cardId}")
    public CardDto deleteTranslationByCardId(@PathVariable Long cardId, @RequestBody TranslationDeleteDto translation) {
        return cardService.deleteTranslationByCardId(cardId, translation);
    }

    @DeleteMapping("/word/{cardId}")
    public CardDto deleteCardById(@PathVariable Long cardId) {
        return cardService.deleteCardById(cardId);
    }

    @GetMapping("/words")
    public List<CardDto> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/words/{number}")
    public List<CardDto> getRandomCards(@PathVariable Long number) {
        return cardService.getRandomCards(number);
    }
}
