package com.navigrad.m2m.server.gps.dao;

import java.util.List;

import com.navigrad.m2m.server.gps.entity.Transport;

public interface ITransportDAO extends IAbstractDAO<Transport> {

	public List<Transport> findTransports();

	public Transport findTransportByImei(String imei);

}
