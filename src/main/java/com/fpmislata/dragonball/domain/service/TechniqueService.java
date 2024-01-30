package com.fpmislata.dragonball.domain.service;

import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.repository.TechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface TechniqueService {
    Optional<Technique> getById(Integer id);
    Technique create(Technique technique);
}
