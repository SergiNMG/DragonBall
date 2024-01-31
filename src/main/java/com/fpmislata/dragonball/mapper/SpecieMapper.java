package com.fpmislata.dragonball.mapper;

import com.fpmislata.dragonball.controller.model.specie.SpecieDetailWeb;
import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.persistence.model.SpecieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SpecieMapper {

    SpecieMapper mapper = Mappers.getMapper(SpecieMapper.class);

    Specie toSpecie(SpecieEntity specieEntity);
    Specie toSpecie(SpecieDetailWeb specieDetailWeb);
    SpecieDetailWeb toSpecieDetailWeb(Specie specie);
    SpecieEntity toSpecieEntity(Specie specie);


}
