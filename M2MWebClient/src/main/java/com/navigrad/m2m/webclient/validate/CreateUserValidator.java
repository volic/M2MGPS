package com.navigrad.m2m.webclient.validate;

public class CreateUserValidator {

	public static String checkPassword(String password) {
		ValidatorResult result = new ValidatorResult("Client password");
		ValidateUtil.checkString(result, password, 32, 3, false);
		if (result.hasError()) {
			return ErrorTextBuilder.buildError(result);
		}
		return null;
	}

	public static String checkTextField(String name, String text) {
		ValidatorResult result = new ValidatorResult(name);
		ValidateUtil.checkString(result, text);
		if (result.hasError()) {
			return ErrorTextBuilder.buildError(result);
		}
		return null;
	}
}
