package com.quoxsii.lanit.letterformatterservice.exception;

import lombok.Getter;

@Getter
public abstract class LetterFormatterServiceException extends RuntimeException {

    protected final String message;

    public LetterFormatterServiceException(String message) {
        this.message = message;
    }

    public LetterFormatterServiceException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }

}
