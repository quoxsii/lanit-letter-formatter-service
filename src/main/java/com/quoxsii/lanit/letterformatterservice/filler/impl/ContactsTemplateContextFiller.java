package com.quoxsii.lanit.letterformatterservice.filler.impl;

import com.quoxsii.lanit.letterformatterservice.filler.TemplateContextFiller;
import com.quoxsii.lanit.letterformatterservice.model.dto.LetterDto;
import com.quoxsii.lanit.letterformatterservice.model.template.ContactsTemplate;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import java.util.Optional;

@Component
public class ContactsTemplateContextFiller implements TemplateContextFiller {

    @Override
    public void fill(Context context, LetterDto letterDto) {
        ContactsTemplate contactsTemplate = new ContactsTemplate();
        contactsTemplate.setNumber(getNumber(letterDto));
        contactsTemplate.setAddress(getAddress(letterDto));

        context.setVariable("contacts", contactsTemplate);
    }

    private String getNumber(LetterDto letterDto) {
        return Optional.ofNullable(letterDto.getDocument())
                .map(LetterDto.Document::getTel)
                .map(LetterDto.Document.Tel::getValue)
                .map(s -> s.replaceAll("[^0-9]", ""))
                .orElse("");
    }

    private String getAddress(LetterDto letterDto) {
        return Optional.ofNullable(letterDto.getDocument())
                .map(LetterDto.Document::getAddress)
                .map(LetterDto.Document.Address::getValue)
                .orElse("");
    }

}
