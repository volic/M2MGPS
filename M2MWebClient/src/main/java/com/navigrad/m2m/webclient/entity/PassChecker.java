package com.navigrad.m2m.webclient.entity;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class PassChecker {

	private PassChecker() {
	}

	public static PassChecker getInstance() {
		return Holder.instance;
	}

	public String getHash(String pass) throws Exception {
		MessageDigest md = null;
		md = MessageDigest.getInstance("MD5");
		md.update(pass.getBytes("UTF-8"));
		byte bytes[] = md.digest();
		String hash = (new BASE64Encoder()).encode(bytes);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return hash;
	}

	private static class Holder {
		private static final PassChecker instance = new PassChecker();
	}
}
