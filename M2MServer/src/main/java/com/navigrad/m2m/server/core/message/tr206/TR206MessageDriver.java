package com.navigrad.m2m.server.core.message.tr206;

import java.util.regex.Pattern;

import com.navigrad.m2m.server.core.IMessageDriver;
import com.navigrad.m2m.server.core.message.IGPSMessage;
import com.navigrad.m2m.server.core.message.ISystemMessage;

public class TR206MessageDriver implements IMessageDriver {

	public TR206MessageDriver(String commandText) {

	}

	@Override
	public String createSendMessage(ISystemMessage iMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGPSMessage getGPSMessage(String message) {

		return new TR206GPSMessage(message);
	}

}
