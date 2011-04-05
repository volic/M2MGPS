package com.navigrad.m2m.webclient.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@ManagedBean(name = "forgetPasswordController")
@RequestScoped
public class ForgetPasswordController {

	@NotEmpty
	private String login;
	@Email
	@NotEmpty
	private String email;
	private boolean accept = false;
	private String errorMessage;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String sendNewPassword() {
		accept=true;
		return "success";
	}

}
