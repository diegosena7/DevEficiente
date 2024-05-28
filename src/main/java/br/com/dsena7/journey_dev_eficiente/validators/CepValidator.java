package br.com.dsena7.journey_dev_eficiente.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<CepValid, String> {

    @Override
    public void initialize(CepValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext constraintValidatorContext) {
        return cep != null && cep.matches("\\d{5}-\\d{3}");
    }
}
