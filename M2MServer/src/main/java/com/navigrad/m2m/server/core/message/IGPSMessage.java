package com.navigrad.m2m.server.core.message;

import java.util.Date;

public interface IGPSMessage {

	public String getImei();
	
	public Date getTime();
	
	public Double getX();
	
	public Double getY();
	
	public Double getZ();
}
