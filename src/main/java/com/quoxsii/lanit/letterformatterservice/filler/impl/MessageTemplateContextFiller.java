package com.quoxsii.lanit.letterformatterservice.filler.impl;

import com.quoxsii.lanit.letterformatterservice.filler.TemplateContextFiller;
import com.quoxsii.lanit.letterformatterservice.model.dto.GreetingDto;
import com.quoxsii.lanit.letterformatterservice.model.dto.LetterDto;
import com.quoxsii.lanit.letterformatterservice.model.template.MessageTemplate;
import com.quoxsii.lanit.letterformatterservice.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageTemplateContextFiller implements TemplateContextFiller {

    private final GreetingService greetingService;

    @Override
    public void fill(Context context, LetterDto letterDto) {
        MessageTemplate messageTemplate = new MessageTemplate();
        messageTemplate.setParagraphs(getParagraphs(letterDto));

        context.setVariable("message", messageTemplate);
    }

    private List<String> getParagraphs(LetterDto letterDto) {
        GreetingDto greetingDto = greetingService.getGreetingByRaceCode(letterDto.getRace().getValue());

        String text = letterDto.getDocument().getText();

        return text.replace("Здравствуйте", greetingDto.getText())
                .trim()
                .lines()
                .map(String::trim)
                .toList();
    }

}
