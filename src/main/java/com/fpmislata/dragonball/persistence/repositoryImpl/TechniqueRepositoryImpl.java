package com.fpmislata.dragonball.persistence.repositoryImpl;

import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.repository.TechniqueRepository;
import com.fpmislata.dragonball.mapper.TechniqueMapper;
import com.fpmislata.dragonball.persistence.dao.TechniqueDAO;
import com.fpmislata.dragonball.persistence.model.CharacterEntity;
import com.fpmislata.dragonball.persistence.model.TechniqueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TechniqueRepositoryImpl implements TechniqueRepository {

    @Autowired
    TechniqueDAO techniqueDAO;

    @Override
    public Optional<Technique> getById(Integer id){
        return Optional.ofNullable(TechniqueMapper.mapper.toTechnique(techniqueDAO.findById(id).orElse(null)));
    }

    @Override
    public Technique save(Technique technique){
        TechniqueEntity techniqueEntity = techniqueDAO.save(TechniqueMapper.mapper.toTechniqueEntity(technique));
        return TechniqueMapper.mapper.toTechnique(techniqueEntity);
    }

    @Override
    public List<Technique> getByName(String name){
        return TechniqueMapper.mapper.toTechniqueList(techniqueDAO.findByName(name));
    }

//    public List<Technique> getByCharacters_Id(Integer characterId){
//        List<TechniqueEntity> techniqueEntityList = techniqueDAO.findByCharacters_Id(characterId);
//        return techniqueMapper.mapper.toTechniqueList(techniqueEntityList);
//    }
}
