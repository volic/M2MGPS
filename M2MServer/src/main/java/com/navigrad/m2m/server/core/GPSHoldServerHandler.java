package com.navigrad.m2m.server.core;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Calendar;
import java.util.logging.Logger;

import org.quickserver.net.server.ClientCommandHandler;
import org.quickserver.net.server.ClientEventHandler;
import org.quickserver.net.server.ClientHandler;

import com.navigrad.m2m.server.core.message.IGPSMessage;

public class GPSHoldServerHandler implements ClientCommandHandler,
		ClientEventHandler {

	private static Logger logger = Logger.getLogger(GPSHoldServerHandler.class
			.getName());

	@Override
	public void closingConnection(ClientHandler handler) throws IOException {
		
		
	}

	@Override
	public void gotConnected(ClientHandler handler) throws SocketTimeoutException,
			IOException {
		logger.fine("Connection opened : " + handler.getHostAddress());
		handler.sendClientMsg("Connection opened : " + handler.getHostAddress());
		
	}

	@Override
	public void lostConnection(ClientHandler handler) throws IOException {
		logger.fine("Connection lost: " + handler.getHostAddress());

	}

	@Override
	public void handleCommand(ClientHandler handler, String commandText)
			throws SocketTimeoutException, IOException {
		System.out.println(Calendar.getInstance() + " Client: " + handler.getHostAddress() + " Command: " + commandText);
		IGPSMessage gpsMessage;
		gpsMessage = MessageDriverManager.getDriver(commandText).getGPSMessage(commandText);
		
		logger.fine(commandText + "\n" + gpsMessage);
		handler.sendClientMsg(gpsMessage.toString());
		
	}

}
