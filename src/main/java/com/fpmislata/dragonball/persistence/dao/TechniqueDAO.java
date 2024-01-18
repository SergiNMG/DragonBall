package com.fpmislata.dragonball.persistence.dao;

import com.fpmislata.dragonball.persistence.model.TechniqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechniqueDAO extends JpaRepository<TechniqueEntity, Integer> {
}
