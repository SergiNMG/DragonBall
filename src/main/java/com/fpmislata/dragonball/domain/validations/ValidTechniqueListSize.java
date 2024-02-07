package com.fpmislata.dragonball.domain.validations;

import com.fpmislata.dragonball.domain.validations.impl.TechniqueListSizeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TechniqueListSizeValidator.class)
public @interface ValidTechniqueListSize{
    String message() default "Un character no puede tener más de 4 técnicas asociadas";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
