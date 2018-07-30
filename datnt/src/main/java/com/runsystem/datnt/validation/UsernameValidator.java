package com.runsystem.datnt.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<UsernameConstraint, String> {

	@Override
	public void initialize(UsernameConstraint arg0) {}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext arg1) {
		String regex = "^[a-zA-Z0-9]{1,25}$";
		return input.matches(regex);
	}
}
