package com.quoxsii.lanit.letterformatterservice.aspect;

import com.quoxsii.lanit.letterformatterservice.exception.LetterFormatterServiceException;
import com.quoxsii.lanit.letterformatterservice.exception.LetterFormattingException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LetterFormattingAspect {

    @AfterThrowing(value = "execution(* com.quoxsii.lanit.letterformatterservice.service.LetterFormatterService.format(..))", throwing = "e")
    public void wrapToLetterFormattingException(Exception e) {
        if (e instanceof LetterFormatterServiceException) {
            return;
        }
        throw new LetterFormattingException(e);
    }

}
