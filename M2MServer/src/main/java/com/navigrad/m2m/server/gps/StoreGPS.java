package com.navigrad.m2m.server.gps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.navigrad.m2m.server.core.message.IGPSMessage;
import com.navigrad.m2m.server.gps.entity.GPSData;
import com.navigrad.m2m.server.gps.entity.Transport;

public class StoreGPS {

	private StoreGPS() {

	}

	public static StoreGPS getInstance() {
		return Holder.instance;
	}

	public Object storeGPS(IGPSMessage message) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("gps.xml");
		TestConection testConection = (TestConection) ctx
				.getBean("TestConection");
		Transport savedTransport = testConection.getTransportDAO()
				.findTransportByImei(message.getImei());
		if (savedTransport == null) {
			Transport newTransport = new Transport();
			newTransport.setImei(message.getImei());
			Long id = testConection.getTransportDAO().add(newTransport);
			savedTransport = testConection.getTransportDAO().getById(id);
		}
		if (savedTransport != null) {
			GPSData newGpsData = new GPSData();
			newGpsData.setTransport(savedTransport);
			newGpsData.setTime(message.getTime());
			newGpsData.setX(message.getX());
			newGpsData.setY(message.getY());
			newGpsData.setZ(message.getZ());
			testConection.getGpsDAO().add(newGpsData);

		}

		return null;
	}

	private static class Holder {

		private static StoreGPS instance = new StoreGPS();

	}
}
