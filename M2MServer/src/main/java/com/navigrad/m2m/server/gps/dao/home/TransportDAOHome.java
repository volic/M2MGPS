package com.navigrad.m2m.server.gps.dao.home;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.navigrad.m2m.server.gps.HibernateUtil;
import com.navigrad.m2m.server.gps.dao.ITransportDAO;
import com.navigrad.m2m.server.gps.entity.Transport;

public class TransportDAOHome extends AbstractDAOHome<Transport> implements
		ITransportDAO {

	@Override
	protected Class<Transport> getDomainEntityClass() {
		return Transport.class;
	}

	@Override
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
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Transport result = (Transport) session.createQuery("from Transport where imei=" + imei);
		session.getTransaction().commit();
		return null;
	}
}
