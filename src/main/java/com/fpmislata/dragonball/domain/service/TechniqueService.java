package com.fpmislata.dragonball.domain.service;

import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.repository.TechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TechniqueService {
    //List<Technique> getByCharacter_Id(Integer characterId);
    Technique create(Technique technique);
}
