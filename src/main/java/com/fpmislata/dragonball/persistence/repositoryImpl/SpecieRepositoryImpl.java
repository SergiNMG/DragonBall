package com.fpmislata.dragonball.persistence.repositoryImpl;

import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.domain.repository.SpecieRepository;
import com.fpmislata.dragonball.mapper.SpecieMapper;
import com.fpmislata.dragonball.persistence.dao.SpecieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SpecieRepositoryImpl implements SpecieRepository {

    @Autowired
    SpecieDAO specieDAO;
    @Autowired
    SpecieMapper specieMapper;

//    public Optional<Specie> getById(Integer id){
//        return Optional.ofNullable(specieMapper.mapper.toSpecie(specieDAO.findById(id).get()));
//    }

//    public Optional<Specie> getByCharacters_Id(Integer characterId){
//        return Optional.ofNullable(specieMapper.mapper.toSpecie(specieDAO.findByCharacters_Id(characterId).get()));
//    }
}
