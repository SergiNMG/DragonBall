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
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public SpecieDetailWeb getById(@PathVariable("id") Integer id){
        return SpecieMapper.mapper.toSpecieDetailWeb(specieService.getById(id).orElseThrow());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public SpecieDetailWeb create(@RequestBody SpecieDetailWeb specieDetailWeb){
        Specie newSpecie = specieService.create(SpecieMapper.mapper.toSpecie(specieDetailWeb));
        return SpecieMapper.mapper.toSpecieDetailWeb(newSpecie);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public SpecieDetailWeb delete(@PathVariable("id") Integer id){
        SpecieDetailWeb specieDeleted = SpecieMapper.mapper.toSpecieDetailWeb(specieService.getById(id).orElseThrow());
        specieService.delete(specieService.getById(id).orElseThrow());
        return specieDeleted;
    }
}
