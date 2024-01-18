package com.fpmislata.dragonball.persistence.repositoryImpl;

import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.repository.TechniqueRepository;
import com.fpmislata.dragonball.mapper.TechniqueMapper;
import com.fpmislata.dragonball.persistence.dao.TechniqueDAO;
import com.fpmislata.dragonball.persistence.model.CharacterEntity;
import com.fpmislata.dragonball.persistence.model.TechniqueEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TechniqueRepositoryImpl implements TechniqueRepository {

    @Autowired
    TechniqueDAO techniqueDAO;
    @Autowired
    TechniqueMapper techniqueMapper;

    public List<Technique> getByCharacter_Id(Integer characterId){
        List<TechniqueEntity> techniqueEntityList = techniqueDAO.findByCharacters_Id(characterId);
        return techniqueMapper.mapper.toTechniqueList(techniqueEntityList);
    }
}
