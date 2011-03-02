package com.navigrad.m2m.server.core.message.tr206;

import java.util.Date;

import com.navigrad.m2m.server.core.message.IGPSMessage;

public class TR206GPSMessage implements IGPSMessage {

	private String imei;
	private Date time;
	private Double x;
	private Double y;
	private Double z;

	public TR206GPSMessage() {
	}

	public TR206GPSMessage(String message) {
		// GSx,IMEI,[T,S,]Field1,Field2,……,FieldN*Checksum!
		// GSS,011412000012789,3,0,X0=32400,X1=64800,X2=3600,X3=3E,X4=80*53!
		message = "GSS,011412000012789,3,0,X0=32400,X1=64800,X2=3600,X3=901158890080,X4=100080,*53!";
		int endPrevious = message.indexOf(",");
		String type = message.substring(0, endPrevious);
		message = message.substring(endPrevious + 1, message.length());
		endPrevious = message.indexOf(",");
		//
		imei = message.substring(0, endPrevious);
		message = message.substring(endPrevious + 1, message.length());
		endPrevious = message.indexOf(",");
		//
		String type2 = message.substring(0, endPrevious);
		message = message.substring(endPrevious + 1, message.length());
		endPrevious = message.indexOf(",");
		//
		String type3 = message.substring(0, endPrevious);
		message = message.substring(endPrevious + 1, message.length());
		endPrevious = message.indexOf(",");
		//
		String x1 = message.substring(0, endPrevious);
		x = Double.valueOf(x1.split("=")[1]);
		message = message.substring(endPrevious + 1, message.length());
		endPrevious = message.indexOf(",");
		//
		String x2 = message.substring(0, endPrevious);
		y = Double.valueOf(x2.split("=")[1]);
		message = message.substring(endPrevious + 1, message.length());
		endPrevious = message.indexOf(",");
		//
		String x3 = message.substring(0, endPrevious);
		z = Double.valueOf(x3.split("=")[1]);
		message = message.substring(endPrevious + 1, message.length());
		endPrevious = message.indexOf(",");
		//
		String time = message.substring(0, endPrevious);
		this.time = new Date(Long.valueOf(time.split("=")[1]));
		message = message.substring(endPrevious + 1, message.length());
		endPrevious = message.indexOf(",");
	}

	@Override
	public String getImei() {
		return imei;
	}

	@Override
	public Date getTime() {
		return time;
	}

	@Override
	public Double getX() {
		return x;
	}

	@Override
	public Double getY() {
		return y;
	}

	@Override
	public Double getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "TR206GPSMessage [imei=" + imei + ", time=" + time + ", x=" + x
				+ ", y=" + y + ", z=" + z + "]";
	}

	public static void main(String[] args) {
		System.out.println(new TR206GPSMessage(""));
	}
}
