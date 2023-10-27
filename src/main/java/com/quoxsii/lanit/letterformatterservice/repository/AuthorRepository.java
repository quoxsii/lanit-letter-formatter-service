package com.quoxsii.lanit.letterformatterservice.repository;

import com.quoxsii.lanit.letterformatterservice.model.entity.AuthorEntity;
import com.quoxsii.lanit.letterformatterservice.model.entity.HeaderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, String> {
}
