package com.quoxsii.lanit.letterformatterservice.aspect;

import com.quoxsii.lanit.letterformatterservice.exception.LetterValidationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.stream.Collectors;

@Aspect
@Component
public class BindingResultAspect {

    @Around(value = "@annotation(HandleBindingResult) && args(*,bindingResult)", argNames = "joinPoint,bindingResult")
    public Object handleBindingResultErrors(ProceedingJoinPoint joinPoint, BindingResult bindingResult) throws Throwable {
        if (bindingResult != null && bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            throw new LetterValidationException(errorMessage);
        }
        return joinPoint.proceed();
    }

}
