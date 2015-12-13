package com.sebskyo.encryptinator.algorithms;

import java.util.Random;

/**
 * The KeySet class is non-static, generating a key only requires a new instance to be made
 */
public class KeySet {
	private int[] primes = new int[2]; // p & q
	private int[] pubKey = new int[2]; // n & e
	private int totient; // (p-1)(q-1)
	private int pvtKey;

	// Values used by the interpreter - for readability
	public static final int KEY_MOD = 0;
	public static final int KEY_PUB = 1;
	public static final int KEY_PVT = 2;

	public KeySet(int primeLimit) { // primeLimit MUST NOT BE LESS THAN 25 - Weird stuff start happening
		Prime.sieveGenerate(primeLimit);
		Random r = new Random();
		primes[0] = Prime.getPrime(r.nextInt(Prime.getLength() - (primeLimit / 2)) + (primeLimit / 2));
		do {
			primes[1] = Prime.getPrime(r.nextInt(Prime.getLength() - (primeLimit / 2)) + (primeLimit / 2));
		} while (primes[1] == primes[0]);
		pubKey[0] = primes[0] * primes[1];
		totient = Utility.totient(primes[0], primes[1]);
		pubKey[1] = Prime.generateCoprime(totient);
		pvtKey = Utility.inverse(pubKey[1], totient);
	}

	public KeySet() {
		this(25);
	}

	public int getValue(int id) {
		switch (id) {
			case 0:
				return pubKey[0];
			case 1:
				return pubKey[1];
			case 2:
				return pvtKey;
			default:
				return 1;
		}
	}

	// Still here incase of needed tests
	@Deprecated
	public void printInfo() {
		System.out.println(primes[0] + " " + primes[1]);
		System.out.println(pubKey[0] + " " + pubKey[1]);
		System.out.println(totient);
		System.out.println(pvtKey);
		System.out.println(Utility.gcd(pvtKey * pubKey[1], totient));
	}
}
