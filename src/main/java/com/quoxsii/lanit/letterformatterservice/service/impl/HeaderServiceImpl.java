package com.quoxsii.lanit.letterformatterservice.service.impl;

import com.quoxsii.lanit.letterformatterservice.exception.LetterDataNotFoundException;
import com.quoxsii.lanit.letterformatterservice.mapper.HeaderMapper;
import com.quoxsii.lanit.letterformatterservice.model.dto.HeaderDto;
import com.quoxsii.lanit.letterformatterservice.model.entity.HeaderEntity;
import com.quoxsii.lanit.letterformatterservice.repository.HeaderRepository;
import com.quoxsii.lanit.letterformatterservice.service.HeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeaderServiceImpl implements HeaderService {

    private final HeaderRepository headerRepository;
    private final HeaderMapper headerMapper;

    @Override
    public HeaderDto getHeaderByRaceCode(String raceCode) {
        HeaderEntity headerEntity = headerRepository.findById(raceCode)
                .orElseThrow(() -> new LetterDataNotFoundException("Header with code " + raceCode + " not found"));
        return headerMapper.entityToDto(headerEntity);
    }

}
