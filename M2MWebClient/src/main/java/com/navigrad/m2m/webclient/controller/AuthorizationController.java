package com.navigrad.m2m.webclient.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.navigrad.m2m.server.gps.entity.User;
import com.navigrad.m2m.server.gps.servises.UserServise;

@ManagedBean(name = "authorizationController")
@RequestScoped
public class AuthorizationController {

	@NotEmpty(message="Empty Login!!!")
	private String login;
	@NotEmpty(message="Empty!!!")
	@Size(min = 4, message="Must be > 4" )
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
		this.password = password;
	}

	public String login() {
		User user = new UserServise().loadUser(login, password);
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
