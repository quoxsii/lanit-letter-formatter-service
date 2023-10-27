package com.quoxsii.lanit.letterformatterservice.repository;

import com.quoxsii.lanit.letterformatterservice.model.entity.GreetingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GreetingRepository extends CrudRepository<GreetingEntity, Long> {

    @Query("select g from GreetingEntity g where g.headerEntity.code = ?1")
    Optional<GreetingEntity> findByRaceCode(String raceCode);

}
