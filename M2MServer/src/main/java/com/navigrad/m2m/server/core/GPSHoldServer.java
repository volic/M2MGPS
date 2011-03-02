package com.navigrad.m2m.server.core;

import java.io.File;

import org.quickserver.net.AppException;
import org.quickserver.net.server.QuickServer;

public class GPSHoldServer {
	public static String version = "1.3";

	public static void main(String s[]) {
		QuickServer holdServer;
		String confFile = "conf" + File.separator + "GPSHoldServer.xml";

		try {
			holdServer = QuickServer.load(confFile);
		} catch (AppException e) {
			System.out.println("Error in server : " + e);
			e.printStackTrace();
		}
	}
}
