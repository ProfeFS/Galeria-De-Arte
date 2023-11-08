package com.cesur.examen.GaleriaDeArte.validators;

import java.lang.annotation.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ArtworkDescriptionValid implements ConstraintValidator<ArtworkDescription, String> {
	

	@Override
	public void initialize(ArtworkDescription constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null || value.trim().isEmpty()) {
			return false;
		}

		String[] palabras = value.trim().split("\\s+");
		return palabras.length >= 5;

	}

}
