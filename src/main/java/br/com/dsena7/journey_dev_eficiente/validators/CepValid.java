package br.com.dsena7.journey_dev_eficiente.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CepValidator.class)
public @interface CepValid {
    String message() default "CEP inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
