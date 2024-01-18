package com.fpmislata.dragonball.mapper;

import com.fpmislata.dragonball.controller.model.technique.TechniqueListWeb;
import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.persistence.model.TechniqueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechniqueMapper {

    TechniqueMapper mapper = Mappers.getMapper(TechniqueMapper.class);

    List<Technique> toTechniqueList(List<TechniqueEntity> techniqueEntityList);

    List<TechniqueListWeb> toTechniqueListWebList(List<Technique> techniqueList);
}
