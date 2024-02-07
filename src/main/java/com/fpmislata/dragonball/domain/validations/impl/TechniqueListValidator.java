package com.fpmislata.dragonball.domain.validations.impl;

import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.validations.ValidTechniqueList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class TechniqueListValidator implements ConstraintValidator<ValidTechniqueList, Character>{

    @Override
    public void initialize(ValidTechniqueList constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Character character, ConstraintValidatorContext constraintValidatorContext) {
        if(character == null || character.getTechniqueList() == null){
            return false;
        }

        Set<Integer> techniqueIds = new HashSet<>();
        for (Technique technique : character.getTechniqueList()) {
            if (!techniqueIds.add(technique.getId())) {
                return false;
            }
        }

        return true;
    }
}
