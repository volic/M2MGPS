package com.navigrad.m2m.webclient.validate;

import java.util.ArrayList;
import java.util.List;

public class ValidateUtil {

	private static final int MAX_STRING_LENGTH = 255;

	public static List<String> checkString(ValidatorResult result, String text) {
		return checkString(result, text, MAX_STRING_LENGTH, 0, false);
	}

	public static List<String> checkString(ValidatorResult result, String text,
			int maxLength, int minLength, boolean onlyChars) {

		List<String> errors = new ArrayList<String>();
		if (text == null || text.length() == 0) {
			result.addError(ValidatorEror.EMPTY_STRING);
		}
		return errors;
	}
}
