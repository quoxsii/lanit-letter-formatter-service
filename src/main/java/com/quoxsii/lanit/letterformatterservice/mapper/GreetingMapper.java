package com.quoxsii.lanit.letterformatterservice.mapper;

import com.quoxsii.lanit.letterformatterservice.model.dto.GreetingDto;
import com.quoxsii.lanit.letterformatterservice.model.entity.GreetingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GreetingMapper {

    @Mapping(source = "headerEntity.code", target = "code")
    GreetingDto entityToDto(GreetingEntity greetingEntity);

}
