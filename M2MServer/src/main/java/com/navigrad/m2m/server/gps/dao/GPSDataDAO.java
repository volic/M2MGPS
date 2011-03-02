package com.navigrad.m2m.server.gps.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.navigrad.m2m.server.gps.HibernateUtil;
import com.navigrad.m2m.server.gps.entity.GPSData;

public class GPSDataDAO implements IGPSDataDAO {

	public Long add(GPSData data) {
		//
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Long result = (Long) session.save(data);
		session.getTransaction().commit();
		return result;
	}

	@Override
	public GPSData getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		GPSData data = (GPSData) session.load(GPSData.class, id);
		Hibernate.initialize(data.getTransport());
		session.getTransaction().commit();
		return data;

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
	public Long delete(GPSData t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long recover(GPSData t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteWithoutRecover(GPSData t) {
		// TODO Auto-generated method stub
		return null;
	}

}
