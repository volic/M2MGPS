package com.navigrad.m2m.server.gps.dao.home;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.navigrad.m2m.server.gps.HibernateUtil;
import com.navigrad.m2m.server.gps.dao.IUserDAO;
import com.navigrad.m2m.server.gps.entity.User;

public class UserDAOHome extends AbstractDAOHome<User> implements IUserDAO {

	@Override
	protected Class<User> getDomainEntityClass() {
		return User.class;
	}
	
	@Override
	public List<User> findUsers() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<User> users = session.createQuery(
		"from User ").list();
		for (User user : users) {
			Hibernate.initialize(user);
		}
		session.getTransaction().commit();
		return users;
	}
	
	@Override
	public User findUserByLogin(String login) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User user = (User) session.createQuery(
		"from User as user where user.login = " + login).uniqueResult();
		session.getTransaction().commit();
		return user;
	}

}
