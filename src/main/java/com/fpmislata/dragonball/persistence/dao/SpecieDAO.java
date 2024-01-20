package com.fpmislata.dragonball.persistence.dao;

import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.persistence.model.SpecieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecieDAO extends JpaRepository<SpecieEntity, Integer> {
    //Optional<SpecieEntity> findByCharacters_Id(Integer characterId);
}
