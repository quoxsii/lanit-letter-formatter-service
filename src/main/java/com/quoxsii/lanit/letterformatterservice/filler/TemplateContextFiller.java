package com.quoxsii.lanit.letterformatterservice.filler;


import com.quoxsii.lanit.letterformatterservice.model.dto.LetterDto;
import org.thymeleaf.context.Context;

public interface TemplateContextFiller {

    void fill(Context context, LetterDto letterDto);

}
