package com.fpmislata.dragonball.persistence.dao;

import com.fpmislata.dragonball.persistence.model.TechniqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechniqueDAO extends JpaRepository<TechniqueEntity, Integer> {
}
