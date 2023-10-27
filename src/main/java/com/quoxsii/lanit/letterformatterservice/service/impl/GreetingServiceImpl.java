package com.quoxsii.lanit.letterformatterservice.service.impl;

import com.quoxsii.lanit.letterformatterservice.exception.LetterDataNotFoundException;
import com.quoxsii.lanit.letterformatterservice.mapper.GreetingMapper;
import com.quoxsii.lanit.letterformatterservice.model.dto.GreetingDto;
import com.quoxsii.lanit.letterformatterservice.model.entity.GreetingEntity;
import com.quoxsii.lanit.letterformatterservice.repository.GreetingRepository;
import com.quoxsii.lanit.letterformatterservice.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository greetingRepository;
    private final GreetingMapper greetingMapper;

    @Override
    public GreetingDto getGreetingByRaceCode(String raceCode) {
        GreetingEntity greetingEntity = greetingRepository.findByRaceCode(raceCode)
                .orElseThrow(() -> new LetterDataNotFoundException("Greeting with code " + raceCode + " not found"));
        return greetingMapper.entityToDto(greetingEntity);
    }

}
