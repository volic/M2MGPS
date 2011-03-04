package com.navigrad.m2m.server.core;

import com.navigrad.m2m.server.core.message.tr206.TR206MessageDriver;

public class MessageDriverManager {

	public static IMessageDriver getDriver(String commandText) {
		
		return new TR206MessageDriver(commandText);
	}

}
