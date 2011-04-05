package com.navigrad.m2m.webclient.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.navigrad.m2m.server.gps.entity.User;
import com.navigrad.m2m.server.gps.servises.UserServise;
import com.navigrad.m2m.server.gps.servises.WrongPasswordException;
import com.navigrad.m2m.webclient.entity.PassChecker;

@ManagedBean(name = "authorizationController")
@RequestScoped
public class AuthorizationController {

	@NotEmpty
	private String login;
	@NotEmpty
	@Size(min = 4, message = "Must be > 4")
	private String password;
	private String errorMessage;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		try {
			this.password = PassChecker.getInstance().getHash(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String login() {
		User user = null;
		try {
			user = new UserServise().loadUser(login, password);
		} catch (WrongPasswordException e1) {
			e1.printStackTrace();
			errorMessage = "Check login or password. They are incorrect";
			return "error";
		}
		HttpServletRequest request = null;
		try {
			request = (HttpServletRequest) FacesContext.getCurrentInstance()
					.getExternalContext().getRequest();
		} catch (NullPointerException e) {

		}

		if (request == null) {
			return "error";
		}
		if (user == null) {
			errorMessage = "Check login or password. They are incorrect";
			return "error";
		}
		request.getSession().setAttribute("userController",
				new UserController(user));

		return "success";
	}

	public String logout() {
		HttpServletRequest request = null;
		try {
			request = (HttpServletRequest) FacesContext.getCurrentInstance()
					.getExternalContext().getRequest();
		} catch (NullPointerException e) {

		}

		if (request == null) {
			return "error";
		}
		request.getSession().removeAttribute("userController");
		return "success";

	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
