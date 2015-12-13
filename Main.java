package com.sebskyo.encryptinator;

import com.sebskyo.encryptinator.algorithms.Crypt;
import com.sebskyo.encryptinator.algorithms.KeySet;
import com.sebskyo.encryptinator.algorithms.Prime;

/**
 * Encryptinator(tm)
 * Author: Sebastian Vikkelsø Elleholm
 * The Main class contains the command line interpreter, it does not actually define any of the algorithms the program uses, simply refers to them in their respective classes
 */
public class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			// Comparison
			System.out.println("Calculating first 30 primes with: Primality Test Algorithm");
			Prime.generatePrimes(30);
			for (int i = 0; i < Prime.getLength(); i++) {
				System.out.print(Prime.getPrime(i) + (i == Prime.getLength()-1 ? "" : ", "));
			}
			System.out.println();
			System.out.println("Calculating first 30 primes with: Sieve of Eratosthenes");
			Prime.sieveGenerate(30);
			for (int i = 0; i < Prime.getLength(); i++) {
				System.out.print(Prime.getPrime(i) + (i == Prime.getLength()-1 ? "" : ", "));
			}

			System.out.println("\n");
			long start, end, diff;
			System.out.println("Calculating 1'000'000 primes with: Primality Test Algorithm");
			start = System.currentTimeMillis();
			Prime.generatePrimes(1000000);
			end = System.currentTimeMillis();
			diff = end-start;
			System.out.println(diff + " ms");

			System.out.println("Calculating 1'000'000 primes with: Sieve of Eratosthenes");
			start = System.currentTimeMillis();
			Prime.generatePrimes(1000000);
			end = System.currentTimeMillis();
			diff = end-start;
			System.out.println(diff + " ms");

			System.exit(0);
		}
		if (args[0].equals("genkey") && args.length >= 2) {
			// genkey <LIMIT>
			int limit = 0;
			try {
				limit = Integer.parseInt(args[1]);
			}
			catch (Exception e) {
				System.out.println("An error occured:\n" + e + "\nSetting limit to default(25)");
			}
			limit = limit < 25 ? 25 : limit;

			KeySet key = new KeySet(limit);
			System.out.println("mod = " + key.getValue(KeySet.KEY_MOD));
			System.out.println("pub = " + key.getValue(KeySet.KEY_PUB));
			System.out.println("pvt = " + key.getValue(KeySet.KEY_PVT));
			System.exit(0);
		}
		if (args[0].equals("encrypt") && args.length >= 4) {
			// encrypt <MESSAGE> <MODULO> <EXPONENT>
			int mod, exp;
			mod = exp = 0;
			try {
				mod = Integer.parseInt(args[2]);
				exp = Integer.parseInt(args[3]);
			}
			catch (Exception e) {
				System.out.println("An error occured:\n" + e);
				System.exit(-2);
			}
			if (mod != 0 && exp != 0) {
				System.out.println(Crypt.encrypt(args[1], mod, exp));
				System.exit(0);
			}
		}
		if (args[0].equals("decrypt") && args.length >= 4) {
			// decrypt <CIPHERTEXT> <MODULO> <EXPONENT>
			int mod, exp;
			mod = exp = 0;
			try {
				mod = Integer.parseInt(args[2]);
				exp = Integer.parseInt(args[3]);
			}
			catch (Exception e) {
				System.out.println("An error occured:\n" + e);
				System.exit(-2);
			}
			if (mod != 0 && exp != 0) {
				System.out.println(Crypt.decrypt(args[1], mod, exp));
				System.exit(0);
			}
		}
		if (args[0].equals("help") || args[0].equals("--help") || args[0].equals("-h")) {
			System.out.println("java -jar encryptinator.jar [COMMAND] <ARGUMENTS>");
			System.out.println("Commands:");
			System.out.println("  (none)                                     compares two prime generating algorithms.");
			System.out.println("  genkey <LIMIT>                             generates a key with a list of <LIMIT> primes, argument is optional.");
			System.out.println("  encrypt <MESSAGE> <MODULO> <EXPONENT>      encrypts a message. Two last arguments are part of the key, run genkey to get one.");
			System.out.println("  decrypt <CIPHERTEXT> <MODULO> <EXPONENT>   decrypts a ciphertext. Remember to use the opposite exponent than that was used to encrypt.");
			System.out.println("  help                                       prints this message.");
			System.out.println();
			System.out.println("For more, goto github.com/sebskyo/encryptinator");
			System.exit(0);
		}
		System.out.println("Wrong usage of program\nUse:java -jar encryptinator.jar help\nfor help.");
		System.exit(-1);
	}
}
