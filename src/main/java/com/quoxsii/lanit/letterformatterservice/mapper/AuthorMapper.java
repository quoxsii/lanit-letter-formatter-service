package com.quoxsii.lanit.letterformatterservice.mapper;

import com.quoxsii.lanit.letterformatterservice.model.dto.AuthorDto;
import com.quoxsii.lanit.letterformatterservice.model.entity.AuthorEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Named("entityToDto")
    @Mapping(source = "positionEntity.name", target = "position")
    AuthorDto entityToDto(AuthorEntity authorEntity);

    @IterableMapping(qualifiedByName = "entityToDto")
    List<AuthorDto> entitiesToDto(List<AuthorEntity> authorEntity);

}
