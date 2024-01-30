package com.fpmislata.dragonball.domain.repository;

import com.fpmislata.dragonball.domain.entity.Technique;

import java.util.List;
import java.util.Optional;

public interface TechniqueRepository {

    Optional<Technique> getById(Integer id);
    Technique create(Technique technique);
    //List<Technique> getByCharacters_Id(Integer characterId);
}
