package com.quoxsii.lanit.letterformatterservice.service;

import com.quoxsii.lanit.letterformatterservice.model.dto.GreetingDto;

public interface GreetingService {

    GreetingDto getGreetingByRaceCode(String raceCode);

}
