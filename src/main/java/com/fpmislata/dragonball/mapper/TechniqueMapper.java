package com.fpmislata.dragonball.mapper;

import com.fpmislata.dragonball.controller.model.technique.TechniqueDetailWeb;
import com.fpmislata.dragonball.controller.model.technique.TechniqueListWeb;
import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.persistence.model.TechniqueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechniqueMapper {

    TechniqueMapper mapper = Mappers.getMapper(TechniqueMapper.class);

    Technique toTechnique(TechniqueEntity techniqueEntity);
    TechniqueEntity toTechniqueEntity(Technique technique);
    TechniqueListWeb toTechniqueListWeb(Technique technique);

    List<Technique> toTechniqueList(List<TechniqueEntity> techniqueEntityList);
    List<TechniqueListWeb> toTechniqueListWebList(List<Technique> techniqueList);
    List<TechniqueEntity> toTechniqueEntityList(List<Technique> techniqueList);

    Technique toTechnique(TechniqueDetailWeb techniqueDetailWeb);
    TechniqueDetailWeb toTechniqueDetailWeb(Technique technique);

}
