package com.fpmislata.dragonball.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "characters")
@Data
@NoArgsConstructor

public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_specie")
    private SpecieEntity specieEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "characters_techniques",
            joinColumns = @JoinColumn(name = "id_character"),
            inverseJoinColumns = @JoinColumn(name = "id_technique")
    )
    private List<TechniqueEntity> techniqueEntityList;
}
