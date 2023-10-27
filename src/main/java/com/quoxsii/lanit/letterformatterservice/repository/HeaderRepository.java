package com.quoxsii.lanit.letterformatterservice.repository;

import com.quoxsii.lanit.letterformatterservice.model.entity.HeaderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends CrudRepository<HeaderEntity, String> {
}
