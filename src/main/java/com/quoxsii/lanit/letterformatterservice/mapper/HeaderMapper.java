package com.quoxsii.lanit.letterformatterservice.mapper;

import com.quoxsii.lanit.letterformatterservice.model.dto.HeaderDto;
import com.quoxsii.lanit.letterformatterservice.model.entity.HeaderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeaderMapper {

    HeaderDto entityToDto(HeaderEntity headerEntity);

}
