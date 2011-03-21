package com.navigrad.m2m.webclient.controller.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuController {

	private List<Menu> menuItems = new ArrayList<Menu>();

	public List<Menu> getMenuItems() {
		menuItems = Arrays.asList(Menu.values());
		return menuItems;
	}

	public void setMenuItems(List<Menu> menuItems) {
		this.menuItems = menuItems;
	}

	
}
