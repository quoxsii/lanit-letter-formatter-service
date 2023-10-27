package com.quoxsii.lanit.letterformatterservice.filler.impl;

import com.quoxsii.lanit.letterformatterservice.filler.TemplateContextFiller;
import com.quoxsii.lanit.letterformatterservice.model.dto.AuthorDto;
import com.quoxsii.lanit.letterformatterservice.model.dto.HeaderDto;
import com.quoxsii.lanit.letterformatterservice.model.dto.LetterDto;
import com.quoxsii.lanit.letterformatterservice.model.template.TitleTemplate;
import com.quoxsii.lanit.letterformatterservice.service.AuthorService;
import com.quoxsii.lanit.letterformatterservice.service.HeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TitleTemplateContextFiller implements TemplateContextFiller {

    private final HeaderService headerService;
    private final AuthorService authorService;

    @Override
    public void fill(Context context, LetterDto letterDto) {
        String raceCode = letterDto.getRace().getValue();
        HeaderDto headerDto = headerService.getHeaderByRaceCode(raceCode);

        TitleTemplate titleTemplate = new TitleTemplate();
        titleTemplate.setDescription(headerDto.getDescription());
        titleTemplate.setTheme(headerDto.getTheme());
        titleTemplate.setCode(raceCode);
        titleTemplate.setDate(getDate(letterDto));
        titleTemplate.setId(letterDto.getUid().getCode().getValue());
        titleTemplate.setEmployees(getEmployees(letterDto));

        context.setVariable("title", titleTemplate);
    }

    private Date getDate(LetterDto letterDto) {
        LocalDateTime dateTime = LocalDateTime.parse(letterDto.getCreated().getDate(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        dateTime = dateTime.plusYears(1);
        dateTime = dateTime.plusMonths(1);
        dateTime = dateTime.plusDays(1);

        return Timestamp.valueOf(dateTime);
    }

    private List<AuthorDto> getEmployees(LetterDto letterDto) {
        Set<String> employeeIds = letterDto.getAuthors().stream()
                .map(a -> a.getId().getValue())
                .collect(Collectors.toSet());

        return authorService.getAuthorsByIds(employeeIds);
    }

}
