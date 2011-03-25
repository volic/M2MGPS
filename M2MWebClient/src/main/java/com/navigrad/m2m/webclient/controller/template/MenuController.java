package com.navigrad.m2m.webclient.controller.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class MenuController {

	private List<Menu> menuItems = new ArrayList<Menu>();
	private Menu activeMenuPage;

	private Menu gerMenuFromRequest() {
		HttpServletRequest request = null;
		try {
			request = (HttpServletRequest) FacesContext.getCurrentInstance()
					.getExternalContext().getRequest();
			if (request != null) {
				String path = request.getRequestURI();
				Menu page = getPageByPath(path);
				if (page != null) {
					return page;
				}
			}
		} catch (NullPointerException e) {

		}
		return null;
	}

	public Menu getActiveMenuPage() {
		activeMenuPage = gerMenuFromRequest();
		return activeMenuPage;
	}

	public List<Menu> getMenuItems() {
		menuItems = Arrays.asList(Menu.values());
		return menuItems;
	}

	private Menu getPageByPath(String path) {
		if (Menu.values() == null || path == null) {
			return null;
		}
		for (int i = 0; i < Menu.values().length; i++) {
			Menu menu = Menu.values()[i];
			if (path.toLowerCase().contains(menu.getAction().toLowerCase())) {
				return menu;
			}
		}
		return null;
	}

	public void setActiveMenuPage(Menu activeMenuPage) {
		this.activeMenuPage = activeMenuPage;
	}

	public void setMenuItems(List<Menu> menuItems) {
		this.menuItems = menuItems;
	}

}
