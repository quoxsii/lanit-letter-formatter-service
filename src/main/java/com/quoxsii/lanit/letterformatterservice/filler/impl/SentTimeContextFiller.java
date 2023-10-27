package com.quoxsii.lanit.letterformatterservice.filler.impl;

import com.quoxsii.lanit.letterformatterservice.filler.TemplateContextFiller;
import com.quoxsii.lanit.letterformatterservice.model.dto.LetterDto;
import com.quoxsii.lanit.letterformatterservice.model.template.SentTimeTemplate;
import com.quoxsii.lanit.letterformatterservice.util.DateTimeUtil;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import java.sql.Timestamp;

@Component
public class SentTimeContextFiller implements TemplateContextFiller {

    @Override
    public void fill(Context context, LetterDto letterDto) {
        SentTimeTemplate sentTimeTemplate = new SentTimeTemplate();
        sentTimeTemplate.setDate(Timestamp.valueOf(DateTimeUtil.getCurrentTimeInUTC()));

        context.setVariable("sentTime", sentTimeTemplate);
    }

}
