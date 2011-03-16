package com.navigrad.m2m.webclient.controller.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "menuController")
@SessionScoped
public class MenuController {

	private List<Menu> menuItems = new ArrayList<Menu>();
	private String activePage;

	public List<Menu> getMenuItems() {
		menuItems = Arrays.asList(Menu.values());
		return menuItems;
	}

	public void setMenuItems(List<Menu> menuItems) {
		this.menuItems = menuItems;
	}

	public String getActivePage() {
		return activePage;
	}

	public void setActivePage(String activePage) {
		this.activePage = activePage;
	}

}
