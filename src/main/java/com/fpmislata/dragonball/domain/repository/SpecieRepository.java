package com.fpmislata.dragonball.domain.repository;

import com.fpmislata.dragonball.domain.entity.Specie;

import java.util.Optional;

public interface SpecieRepository {
    Optional<Specie> getById(Integer id);
    Specie save(Specie specie);
    void delete(Specie specie);
}
