package com.fpmislata.dragonball.persistence.dao;

import com.fpmislata.dragonball.persistence.model.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterDAO extends JpaRepository<CharacterEntity, Integer> {
}
