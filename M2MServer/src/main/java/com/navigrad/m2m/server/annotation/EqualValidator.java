package com.navigrad.m2m.server.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualValidator implements ConstraintValidator<Equal, String> {

	private String propertyName;

	@Override
	public void initialize(Equal constraintAnnotation) {
		propertyName = constraintAnnotation.propertyName();
		constraintAnnotation.payload();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println(context);
		return false;
	}

}
