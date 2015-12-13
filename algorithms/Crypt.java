package com.sebskyo.encryptinator.algorithms;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * The Crypt class is a static class that handles all en/decryption and en/decoding
 */
public class Crypt {

	public static final Charset UTF8 = Charset.forName("UTF-8");

	public static String encrypt(byte[] msg, int mod, int exp) {
		// Converts parsed values to BigIntegers
		BigInteger bigExp = new BigInteger(Integer.toString(exp));
		BigInteger bigMod = new BigInteger(Integer.toString(mod));
		String[] result = new String[msg.length]; // Will store encrypted numbers as a strings
		for (int i = 0; i < msg.length; i++) {
			result[i] = Integer.toString(new BigInteger(Integer.toString((int)msg[i] & 0xff)).modPow(bigExp, bigMod).intValue()); // Converts and encrypts a byte to a string using bit-level trickery
		}
		return Base64.getEncoder().encodeToString((String.join("+", result).getBytes())); // Joins the string array into a single string and encodes it to Base64
	}

	public static String encrypt(String msg, int mod, int exp) {
		return encrypt(msg.getBytes(UTF8), mod, exp); // Splits the parsed string into bytes so it kan be used by encrypt(byte[], mod, exp)
	}

	public static String decrypt(int[] msg, int mod, int exp) {
		// Converts parsed values to BigIntegers
		BigInteger bigExp = new BigInteger(Integer.toString(exp));
		BigInteger bigMod = new BigInteger(Integer.toString(mod));
		byte[] byteArr = new byte[msg.length]; // Will store decrypted numbers (which are actually strings) as bytes
		for (int i = 0; i < msg.length; i++) {
			byteArr[i] = (byte)new BigInteger(Integer.toString(msg[i])).modPow(bigExp, bigMod).intValue(); // Decrypts and stores as a byte
		}
		return new String(byteArr, UTF8); // Creates and returns a string constructed from the byte array as UTF-8
	}

	public static String decrypt(String msg, int mod, int exp) {
		msg = new String(Base64.getDecoder().decode(msg)); // Decodes the Base64 string
		String[] msgArr = msg.split("\\+"); // Splits the string into an array - which will only contain numbers
		int[] intArr = new int[msgArr.length]; // The int array that will store what is currently in the string array
		for (int i = 0; i < msgArr.length; i++) {
			intArr[i] = Integer.parseInt(msgArr[i]); // The actual int is created
		}
		return decrypt(intArr, mod, exp);
	}
}
