package com.fpmislata.dragonball.persistence.dao;

import com.fpmislata.dragonball.persistence.model.SpecieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecieDAO extends JpaRepository<SpecieEntity, Integer> {
}
