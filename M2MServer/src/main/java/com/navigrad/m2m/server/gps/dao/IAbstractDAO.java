package com.navigrad.m2m.server.gps.dao;

import com.navigrad.m2m.server.gps.entity.AbstractEntity;

public interface IAbstractDAO<T extends AbstractEntity> {

	public Long add(T t);

	public Long delete(T t);

	public Long recover(T t);

	public Long deleteWithoutRecover(T t);

	public T getById(Long id);
}
