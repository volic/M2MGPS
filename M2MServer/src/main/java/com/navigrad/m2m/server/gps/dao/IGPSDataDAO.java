package com.navigrad.m2m.server.gps.dao;

import java.util.List;

import com.navigrad.m2m.server.gps.entity.AbstractEntity;
import com.navigrad.m2m.server.gps.entity.GPSData;

public interface IGPSDataDAO extends IAbstractDAO<GPSData>{

	public List<GPSData> findGPSs();
}
