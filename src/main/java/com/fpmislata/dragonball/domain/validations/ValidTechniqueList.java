package com.fpmislata.dragonball.domain.validations;

import com.fpmislata.dragonball.domain.validations.impl.TechniqueListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TechniqueListValidator.class)
public @interface ValidTechniqueList {
    String message() default "Las técnicas deben ser únicas";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

