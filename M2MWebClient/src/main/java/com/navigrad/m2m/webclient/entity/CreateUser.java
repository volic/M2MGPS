package com.navigrad.m2m.webclient.entity;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.navigrad.m2m.server.gps.entity.User;
import com.navigrad.m2m.server.gps.servises.UserServise;
import com.navigrad.m2m.webclient.validate.CreateUserValidator;

@ManagedBean(name = "createuser")
@SessionScoped
public class CreateUser {

	private String login;
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	private String email;
	private String passwordError;
	private String loginError;
	private String firstNameError;
	private String lastNameError;
	private String confirmPasswordError;

	public String createNewUser() {

		passwordError = CreateUserValidator.checkPassword(password);
		if (!password.equals(confirmPassword)) {
			confirmPasswordError = "Psswords didn't match";
		}
		loginError = CreateUserValidator.checkTextField("Login", login);
		firstNameError = CreateUserValidator.checkTextField("First name",
				firstName);
		lastNameError = CreateUserValidator.checkTextField("Last name",
				lastName);
		if (passwordError != null || loginError != null
				|| firstNameError != null || lastNameError != null)
			return "error";
		new UserServise().saveUser(login, password, firstName, lastName, email);
		return "success";

	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getConfirmPasswordError() {
		return confirmPasswordError;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFirstNameError() {
		return firstNameError;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLastNameError() {
		return lastNameError;
	}

	public String getLogin() {
		return login;
	}

	public String getLoginError() {
		return loginError;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordError() {
		return passwordError;
	}

	List<User> getUsers(){
		return UserServise.getSavedUsers();
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
