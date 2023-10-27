package com.quoxsii.lanit.letterformatterservice.model.template;

import com.quoxsii.lanit.letterformatterservice.model.dto.AuthorDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TitleTemplate {

    private String description;

    private String theme;

    private String code;

    private Date date;

    private String id;

    private List<AuthorDto> employees;

}
