package com.fpmislata.dragonball.controller;

import com.fpmislata.dragonball.controller.model.specie.SpecieDetailWeb;
import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.domain.service.SpecieService;
import com.fpmislata.dragonball.mapper.SpecieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/species")
public class SpecieController {

    @Autowired
    SpecieService specieService;

    //Empleo modelo SpecieDetailWeb porque tiene los atributos que necesito parar insertar
    //Devuelvo la Specie insertada
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Specie create(@RequestBody SpecieDetailWeb specieDetailWeb){
        return specieService.create(SpecieMapper.mapper.toSpecie(specieDetailWeb));
    }
}
