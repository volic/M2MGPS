package com.navigrad.m2m.server.gps.dao;

import java.util.List;

import org.hibernate.Hibernate;

import org.hibernate.Session;

import com.navigrad.m2m.server.gps.HibernateUtil;
import com.navigrad.m2m.server.gps.dao.home.AbstractDAOHome;
import com.navigrad.m2m.server.gps.entity.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO{

	@Override
	public Long add(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Long result = (Long) session.save(user);
		session.getTransaction().commit();
		return result;
	}

	@Override
	public User getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User user = (User) session.load(User.class, id);
		Hibernate.initialize(user.getPassword());
		session.getTransaction().commit();
		return user;

	}

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
	public Long delete(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long recover(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteWithoutRecover(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
