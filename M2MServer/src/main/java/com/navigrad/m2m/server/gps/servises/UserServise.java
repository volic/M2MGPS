package com.navigrad.m2m.server.gps.servises;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.navigrad.m2m.server.gps.TestConection;
import com.navigrad.m2m.server.gps.entity.User;

public class UserServise {

	public Long saveUser(String login, String password, String firstName,
			String lastName, String email) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("gps.xml");
		TestConection testConection = (TestConection) ctx
				.getBean("TestConection");
		User user = testConection.getUserDAO().findUserByLogin(login);
		if (user == null) {
			User newUser = new User();
			newUser.setLogin(login);
			newUser.setLastName(lastName);
			newUser.setFirstName(firstName);
			newUser.setPassword(password);
			return testConection.getUserDAO().add(newUser);
		}
		return null;
	}

	public static List<User> getSavedUsers() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("gps.xml");
		TestConection testConection = (TestConection) ctx
				.getBean("TestConection");
		return testConection.getUserDAO().findUsers();
	}

	public User loadUser(String login, String password)
			throws WrongPasswordException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("gps.xml");
		TestConection testConection = (TestConection) ctx
				.getBean("TestConection");
		User user = testConection.getUserDAO().findUserByLogin(login);
		if (password == null || !password.equals(user.getPassword())) {
			throw new WrongPasswordException("User: " + login
					+ " has different password");
		}
		return user;
	}

	public boolean isUserExist(String login) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("gps.xml");
		TestConection testConection = (TestConection) ctx
				.getBean("TestConection");
		User user = testConection.getUserDAO().findUserByLogin(login);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
}
