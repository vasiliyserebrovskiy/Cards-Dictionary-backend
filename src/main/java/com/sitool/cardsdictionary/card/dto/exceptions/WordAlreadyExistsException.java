package com.sitool.cardsdictionary.card.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class WordAlreadyExistsException extends RuntimeException {
    public WordAlreadyExistsException(String message) {
        super(message);
    }
}
