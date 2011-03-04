package com.navigrad.m2m.server.core;

import com.navigrad.m2m.server.core.message.IGPSMessage;
import com.navigrad.m2m.server.core.message.ISystemMessage;

public interface IMessageDriver {

	public String createSendMessage(ISystemMessage iMessage);
	
	public IGPSMessage getGPSMessage(String message);
	
}
