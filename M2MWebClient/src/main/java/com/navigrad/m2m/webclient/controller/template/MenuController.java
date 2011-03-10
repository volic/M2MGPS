package com.navigrad.m2m.webclient.controller.template;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MenuController {

//	private String createUser;
//	private String authorization;
//	private String home;

	public String getCreateUser() {
		return "createUser";
	}

	public String getAuthorization() {
		return "authorization";
	}

	public String getHome() {
		return "home";
	}

}
