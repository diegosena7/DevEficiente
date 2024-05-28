package br.com.dsena7.journey_dev_eficiente.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface ExistsId {
    String message() default "{com.deveficiente.beanvalidation.existsid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String fieldName();

    Class<?> domainClass();
}
