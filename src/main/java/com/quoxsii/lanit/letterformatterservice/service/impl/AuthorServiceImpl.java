package com.quoxsii.lanit.letterformatterservice.service.impl;

import com.quoxsii.lanit.letterformatterservice.exception.LetterDataNotFoundException;
import com.quoxsii.lanit.letterformatterservice.mapper.AuthorMapper;
import com.quoxsii.lanit.letterformatterservice.model.dto.AuthorDto;
import com.quoxsii.lanit.letterformatterservice.model.entity.AuthorEntity;
import com.quoxsii.lanit.letterformatterservice.repository.AuthorRepository;
import com.quoxsii.lanit.letterformatterservice.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorDto> getAuthorsByIds(Set<String> ids) {
        List<AuthorEntity> authorEntities = (List<AuthorEntity>) authorRepository.findAllById(ids);

        if (!Objects.equals(ids.size(), authorEntities.size())) {
            List<String> foundIds = authorEntities.stream()
                    .map(AuthorEntity::getId)
                    .toList();

           String notFoundIds = ids.stream()
                   .filter(s -> !foundIds.contains(s))
                   .collect(Collectors.joining(", "));

            throw new LetterDataNotFoundException("No authors found for given ids: " + notFoundIds);
        }

        return authorMapper.entitiesToDto(authorEntities);
    }

}
