package com.quoxsii.lanit.letterformatterservice.controller;

import com.quoxsii.lanit.letterformatterservice.aspect.HandleBindingResult;
import com.quoxsii.lanit.letterformatterservice.model.dto.LetterDto;
import com.quoxsii.lanit.letterformatterservice.service.LetterFormatterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/letter",
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
@RequiredArgsConstructor
public class LetterController {

    private final LetterFormatterService letterFormatterService;

    @HandleBindingResult
    @PostMapping(value = "/format")
    public String format(@Valid @RequestBody LetterDto letterDto, BindingResult bindingResult) {
        return letterFormatterService.format(letterDto);
    }

}
