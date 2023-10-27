package com.quoxsii.lanit.letterformatterservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "POSITIONS")
public class PositionEntity {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "name")
    private String name;

}
