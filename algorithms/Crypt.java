package com.sebskyo.encryptinator.algorithms;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Base64;

public class Crypt {

	public static final Charset UTF8 = Charset.forName("UTF-8");

	public static String encrypt(byte[] msg, int mod, int exp) {
		BigInteger bigExp = new BigInteger(Integer.toString(exp));
		BigInteger bigMod = new BigInteger(Integer.toString(mod));
		int[] intArr = new int[msg.length];
		String[] result = new String[intArr.length];
		for (int i = 0; i < msg.length; i++) {
			intArr[i] = new BigInteger(Integer.toString((int)msg[i] & 0xff)).modPow(bigExp, bigMod).intValue(); // shitty bit-level trickery
			result[i] = Integer.toString(intArr[i]);
		}
		return Base64.getEncoder().encodeToString((String.join("+", result).getBytes()));
	}

	public static String encrypt(String msg, int mod, int exp) {
		return encrypt(msg.getBytes(UTF8), mod, exp);
	}

	public static String decrypt(int[] msg, int mod, int exp) {
		BigInteger bigExp = new BigInteger(Integer.toString(exp));
		BigInteger bigMod = new BigInteger(Integer.toString(mod));
		byte[] byteArr = new byte[msg.length];
		for (int i = 0; i < msg.length; i++) {
			msg[i] = new BigInteger(Integer.toString(msg[i])).modPow(bigExp, bigMod).intValue();
			byteArr[i] = (byte)msg[i];
		}
		return new String(byteArr, UTF8);
	}

	public static String decrypt(String msg, int mod, int exp) {
		msg = new String(Base64.getDecoder().decode(msg));
		String[] msgArr = msg.split("\\+");
		int[] intArr = new int[msgArr.length];
		for (int i = 0; i < msgArr.length; i++) {
			intArr[i] = Integer.parseInt(msgArr[i]);
		}
		return decrypt(intArr, mod, exp);
	}
}
