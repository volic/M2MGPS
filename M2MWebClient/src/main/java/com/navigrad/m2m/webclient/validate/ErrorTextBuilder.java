package com.navigrad.m2m.webclient.validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorTextBuilder {

	private static final String EMPTY = "is empty field. Please fill it";
	//
	private static Map<ValidatorEror, String> errorMap = new HashMap<ValidatorEror, String>();

	private ValidatorResult result;
	private String errorText;

	static {
		errorMap.put(ValidatorEror.EMPTY_STRING, EMPTY);
	}

	public static String buildError(ValidatorResult result) {

		List<ValidatorEror> errors = result.getErrors();
		StringBuilder errorBuilder = new StringBuilder();
		for (ValidatorEror validatorEror : errors) {

			switch (validatorEror) {
			case EMPTY_STRING:

			default:
				errorBuilder.append(result.getFieldName() + " "
						+ errorMap.get(validatorEror) + ". ");
				break;

			}

		}
		return errorBuilder.toString();

	}

	public String getText() {

		return null;
	}

}
