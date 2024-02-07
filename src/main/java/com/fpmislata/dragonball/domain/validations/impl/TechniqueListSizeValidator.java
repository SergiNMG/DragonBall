package com.fpmislata.dragonball.domain.validations.impl;

import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.domain.validations.ValidTechniqueListSize;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TechniqueListSizeValidator implements ConstraintValidator<ValidTechniqueListSize, Character> {

    @Override
    public void initialize(ValidTechniqueListSize constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Character character, ConstraintValidatorContext constraintValidatorContext) {
        if (character == null ||character.getTechniqueList() == null){
            return false;
        }

        return character.getTechniqueList().size() <= 4;
    }
}
