package com.navigrad.m2m.webclient.validate;

import java.util.ArrayList;
import java.util.List;

public class ValidatorResult {

	private String fieldName;
	List<ValidatorEror> errors = new ArrayList<ValidatorEror>();

	public ValidatorResult(String fieldName) {
		this.fieldName = fieldName;
	}

	public void addError(ValidatorEror error) {
		errors.add(error);
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public List<ValidatorEror> getErrors() {
		return errors;
	}

	void clearError() {
		errors.clear();
	}

	public boolean hasError() {

		return errors.size() > 0 ? true : false;
	}
}
