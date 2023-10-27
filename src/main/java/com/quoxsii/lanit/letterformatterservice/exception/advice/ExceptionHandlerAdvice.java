package com.quoxsii.lanit.letterformatterservice.exception.advice;

import com.quoxsii.lanit.letterformatterservice.exception.LetterDataNotFoundException;
import com.quoxsii.lanit.letterformatterservice.exception.LetterFormatterServiceException;
import com.quoxsii.lanit.letterformatterservice.exception.LetterFormattingException;
import com.quoxsii.lanit.letterformatterservice.exception.LetterValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = {LetterValidationException.class, LetterFormattingException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError letterValidationExceptionHandler(LetterFormatterServiceException exception) {
        return new ResponseError(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(value = LetterDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseError letterDataNotFoundExceptionHandler(LetterDataNotFoundException exception) {
        return new ResponseError(HttpStatus.NOT_FOUND, exception.getMessage());
    }

}