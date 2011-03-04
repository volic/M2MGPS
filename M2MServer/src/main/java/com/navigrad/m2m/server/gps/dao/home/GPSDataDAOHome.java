package com.navigrad.m2m.server.gps.dao.home;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.navigrad.m2m.server.gps.HibernateUtil;
import com.navigrad.m2m.server.gps.dao.IGPSDataDAO;
import com.navigrad.m2m.server.gps.entity.GPSData;

public class GPSDataDAOHome extends AbstractDAOHome<GPSData> implements
		IGPSDataDAO {

	@Override
	protected Class<GPSData> getDomainEntityClass() {
		return GPSData.class;
	}

	@Override
	public List<GPSData> findGPSs() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<GPSData> datas = (List<GPSData>) session.createQuery(
				"from GPSData order by time").list();
		for (GPSData gpsData : datas) {
			Hibernate.initialize(gpsData.getTransport());
		}

		session.getTransaction().commit();
		return datas;
	}

	@Override
	public GPSData getById(Long id) {
//		GPSData data = super.getById(id);
//		return data;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		GPSData data = (GPSData) session.load(getDomainEntityClass(), id);
		Hibernate.initialize(data.getTransport());
		session.getTransaction().commit();
		return data;
	}
}
