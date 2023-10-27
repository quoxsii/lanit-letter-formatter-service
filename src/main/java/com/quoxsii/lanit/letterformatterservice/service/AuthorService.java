package com.quoxsii.lanit.letterformatterservice.service;

import com.quoxsii.lanit.letterformatterservice.model.dto.AuthorDto;

import java.util.List;
import java.util.Set;

public interface AuthorService {

    List<AuthorDto> getAuthorsByIds(Set<String> ids);

}
