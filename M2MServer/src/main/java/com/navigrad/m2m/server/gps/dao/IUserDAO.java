package com.navigrad.m2m.server.gps.dao;

import java.util.List;

import com.navigrad.m2m.server.gps.entity.User;

public interface IUserDAO extends IAbstractDAO<User> {

	List<User> findUsers();

	User findUserByLogin(String login);

}
