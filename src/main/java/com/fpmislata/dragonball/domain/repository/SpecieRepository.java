package com.fpmislata.dragonball.domain.repository;

import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.domain.entity.Technique;

import java.util.List;
import java.util.Optional;

public interface SpecieRepository {
    Optional<Specie> getById(Integer id);
    Specie save(Specie specie);
    void delete(Specie specie);
    List<Specie> getByName(String name);
}
