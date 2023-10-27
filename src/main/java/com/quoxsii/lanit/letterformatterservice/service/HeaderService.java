package com.quoxsii.lanit.letterformatterservice.service;

import com.quoxsii.lanit.letterformatterservice.model.dto.HeaderDto;

public interface HeaderService {

    HeaderDto getHeaderByRaceCode(String raceCode);

}
