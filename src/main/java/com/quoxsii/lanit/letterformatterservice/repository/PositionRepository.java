package com.quoxsii.lanit.letterformatterservice.repository;

import com.quoxsii.lanit.letterformatterservice.model.entity.HeaderEntity;
import com.quoxsii.lanit.letterformatterservice.model.entity.PositionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<PositionEntity, String> {
}
