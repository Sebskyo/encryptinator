package com.sebskyo.encryptinator.algorithms;

import java.util.Random;

public class KeySet {
    int[] primes = new int[2]; // p & q
    int[] pubKey = new int[2]; // n & e
    int totient; // (p-1)(q-1)
    int pvtKey;

    public KeySet(int primeLimit) { // primeLimit MUST NOT BE LESS THAN 25 - SPPOKY STUFF HAPPENS
        Prime.generatePrimes(primeLimit);
        Random r = new Random();
        primes[0] = Prime.getPrime(r.nextInt(Prime.getLength()-(primeLimit/2))+(primeLimit/2));
        do {
            primes[1] = Prime.getPrime(r.nextInt(Prime.getLength()-(primeLimit/2))+(primeLimit/2));
        } while(primes[1] == primes[0]);
        pubKey[0] = primes[0]*primes[1];
        totient = Utility.totient(primes[0], primes[1]);
        pubKey[1] = Prime.generateCoprime(totient);
        pvtKey = Utility.inverse(pubKey[1], totient);
    }
    public KeySet() {
        this(25);
    }

    public void printInfo() {
        System.out.println(primes[0] + " " + primes[1]);
        System.out.println(pubKey[0] + " " + pubKey[1]);
        System.out.println(totient);
        System.out.println(pvtKey);
        System.out.println(Utility.gcd(pvtKey*pubKey[1], totient));
    }
}
