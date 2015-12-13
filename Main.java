package com.sebskyo.encryptinator;

import com.sebskyo.encryptinator.algorithms.KeySet;

/**
 * Encryptinator(tm)
 * Author: Sebastian Vikkelsø Elleholm
 */
public class Main {
	public static void main(String[] args) {
		/*if (args.length == 0) {
			// TODO: algorithm comparison
			System.exit(0);
		}
		if (args[0].equals("genkey") && args.length >= 2) {
			// TODO: generate key <LIMIT>
			System.exit(0);
		}
		if (args[0].equals("encrypt") && args.length >= 4) {
			// TODO: encrypt <MESSAGE> <MODULO> <EXPONENT>
			System.exit(0);
		}
		if (args[0].equals("decrypt") && args.length >= 4) {
			// TODO: decrypt <CIPHERTEXT> <MODULO> <EXPONENT>
			System.exit(0);
		}
		if (args[0].equals("help")) {
			// TODO: print help message
			System.exit(0);
		}
		System.out.println("Wrong usage of program\nUse:java -jar encryptinator help\nfor help.");
		System.exit(-1);*/

		KeySet key = new KeySet(25);
		key.printInfo();
		key.crypt("this works");
	}
}
