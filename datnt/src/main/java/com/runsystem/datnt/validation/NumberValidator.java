package com.runsystem.datnt.validation;

public class NumberValidator {
	
	public static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
