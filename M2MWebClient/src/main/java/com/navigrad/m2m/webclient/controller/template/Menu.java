package com.navigrad.m2m.webclient.controller.template;

public enum Menu {
	HOME("Home", "home", ""), CREATE_USER("Create User", "createUser", ""), AUTHORIZATION(
			"Authorization", "authorization", "");
	private String title;
	private String styleClass;
	private String action;

	private Menu(String title, String action, String styleClass) {
		this.title = title;
		this.action = action;
		this.styleClass = styleClass;
	}

	public String getTitle() {
		return title;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public String getAction() {
		return action;
	}

	public String action() {
		return action;
	}
}
