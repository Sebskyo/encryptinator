package com.sebskyo.encryptinator.algorithms;

import java.util.Random;
import java.util.Iterator;

/**
 * The static Prime class handles all algorithms to do with (co)prime numbers
 */
public class Prime {
	private static int[] primes;

	public static void sieveGenerate(int limit) {
		// Preparing statements
		int[] tmpPrimes = new int[limit];
		Iterator<Integer> iterator = new IntegerIterator();
		for (int i = 0; i < limit; i++) {
			int next = iterator.next(); // Gets next prime
			tmpPrimes[i] = next; // Stores it
			iterator = new FilterIterator(iterator, next); // Creates new filter to use in next iteration
		}
		primes = tmpPrimes; // Parses data to the permanent array
	}

	public static void generatePrimes(int limit) {
		// Preparing statements
		int[] tmpPrimes = new int[limit];
		int index = 1;
		tmpPrimes[0] = 2;
		tmpPrimes[limit-1] = 0;
		for(int i = 3; tmpPrimes[limit-1] == 0; i++) {
			boolean isPrime = true;
			for(int j = 2; j*j <= i; j++) {
				if(i%j == 0) { // The actual checker
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				tmpPrimes[index] = i; // Stores the found prime
				index++; // Moves to next index
			}
		}
		primes = tmpPrimes; // Parses data to the permanent array
	}

	public static int generateCoprime(int i) {
		int j = 0;
		while (getPrime(j) < i && j < getLength())
			j++;
		Random r = new Random();
		int k;
		do {
			k = getPrime(r.nextInt(j / 4));
		} while (i % k == 0);
		return k;
	}

	public static int getPrime(int index) {
		return index < getLength() ? primes[index] : 2;
	}

	public static int getLength() {
		return primes.length;
	}
}
