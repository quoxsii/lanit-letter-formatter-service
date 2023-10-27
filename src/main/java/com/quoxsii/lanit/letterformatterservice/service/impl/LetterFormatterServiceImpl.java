package com.quoxsii.lanit.letterformatterservice.service.impl;

import com.quoxsii.lanit.letterformatterservice.model.dto.LetterDto;
import com.quoxsii.lanit.letterformatterservice.filler.TemplateContextFiller;
import com.quoxsii.lanit.letterformatterservice.service.LetterFormatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LetterFormatterServiceImpl implements LetterFormatterService {

    private final List<TemplateContextFiller> templateContextFillers;
    private final SpringTemplateEngine templateEngine;

    @Override
    public String format(LetterDto letterDto) {
        TemplateSpec templateSpec = new TemplateSpec("letter", TemplateMode.HTML);
        Context context = new Context();
        templateContextFillers.forEach(t -> t.fill(context, letterDto));
        return templateEngine.process(templateSpec, context);
    }

}
