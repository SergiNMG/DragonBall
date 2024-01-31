package com.fpmislata.dragonball.persistence.repositoryImpl;

import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.domain.repository.SpecieRepository;
import com.fpmislata.dragonball.mapper.SpecieMapper;
import com.fpmislata.dragonball.persistence.dao.SpecieDAO;
import com.fpmislata.dragonball.persistence.model.SpecieEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SpecieRepositoryImpl implements SpecieRepository {

    @Autowired
    SpecieDAO specieDAO;

    @Override
    @Transactional
    public Specie create(Specie specie) {
       SpecieEntity specieEntity = specieDAO.save(SpecieMapper.mapper.toSpecieEntity(specie));
       return SpecieMapper.mapper.toSpecie(specieEntity);
    }

    public Optional<Specie> getById(Integer id){
        SpecieEntity specieEntity = specieDAO.findById(id).orElse(null);
        return specieEntity == null ? Optional.empty() : Optional.of(SpecieMapper.mapper.toSpecie(specieEntity));
    }

    public void delete(Specie specie){
        specieDAO.delete(SpecieMapper.mapper.toSpecieEntity(specie));
    }

//    public Optional<Specie> getById(Integer id){
//        return Optional.ofNullable(specieMapper.mapper.toSpecie(specieDAO.findById(id).get()));
//    }

//    public Optional<Specie> getByCharacters_Id(Integer characterId){
//        return Optional.ofNullable(specieMapper.mapper.toSpecie(specieDAO.findByCharacters_Id(characterId).get()));
//    }
}
