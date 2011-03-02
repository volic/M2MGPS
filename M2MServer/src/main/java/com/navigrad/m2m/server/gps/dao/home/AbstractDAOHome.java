package com.navigrad.m2m.server.gps.dao.home;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.navigrad.m2m.server.gps.HibernateUtil;
import com.navigrad.m2m.server.gps.dao.IAbstractDAO;
import com.navigrad.m2m.server.gps.entity.AbstractEntity;

public abstract class AbstractDAOHome<T extends AbstractEntity> implements
		IAbstractDAO<T> {

	@Override
	public Long add(AbstractEntity entity) {
		Long result = (Long) new HibernateTemplate(
				HibernateUtil.getSessionFactory()).save(entity);
		return result;
	}

	@Override
	public Long delete(AbstractEntity entity) {
		return null;
	}

	@Override
	public Long recover(AbstractEntity entity) {
		return null;
	}

	@Override
	public Long deleteWithoutRecover(AbstractEntity entity) {
		return null;
	}

	@Override
	public T getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			T data = (T) session.get(getDomainEntityClass(), id);

			if (data == null) {
				return null;
			}
			if (!Hibernate.isInitialized(data)) {
				Hibernate.initialize(data);
			}
			return data;
		} finally {
			session.getTransaction().commit();
		}
	}

	protected abstract Class<T> getDomainEntityClass();

}
