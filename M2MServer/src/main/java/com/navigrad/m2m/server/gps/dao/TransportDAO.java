package com.navigrad.m2m.server.gps.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.navigrad.m2m.server.gps.HibernateUtil;
import com.navigrad.m2m.server.gps.entity.Transport;

public class TransportDAO implements ITransportDAO{

	public Long add(Transport data) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Long result = (Long) session.save(data);
		session.getTransaction().commit();
		return result;
	}

	@Override
	public Transport getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Transport data = (Transport) session.load(Transport.class, id);
		Hibernate.initialize(data.getGpsDatas());
		session.getTransaction().commit();
		return data;

	}

	public List<Transport> findTransports() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Transport> result = session.createQuery(
				"from Transport order by imei, name").list();
		// Насильная инициализация списка. Вообщем-то не очень хорошая практика
		// так делать
		for (Transport transport : result) {
			Hibernate.initialize(transport.getUser());
		}
		session.getTransaction().commit();
		return result;

	}

	@Override
	public Transport findTransportByImei(String imei) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long delete(Transport t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long recover(Transport t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteWithoutRecover(Transport t) {
		// TODO Auto-generated method stub
		return null;
	}

}
