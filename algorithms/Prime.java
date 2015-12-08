package com.sebskyo.encryptinator.algorithms;

import java.util.Random;
import java.util.Iterator;

public class Prime {
    private static int[] primes = generatePrimes(10);

    public static int[] generatePrimes(int limit) {
        int[] tmpPrimes = new int[limit];
        Iterator<Integer> iterator = new IntegerIterator();
        for(int i = 0; i < limit; i++) {
            int next = iterator.next();
            tmpPrimes[i] = next;
            iterator = new FilterIterator(iterator, next);
        }
        primes = tmpPrimes;
        return tmpPrimes;
    }
    public static int generateCoprime(int i) {
        int j = 0;
        while(getPrime(j) < i && j < getLength())
            j++;
        Random r = new Random();
        int k;
        do {
            k = getPrime(r.nextInt(j/4));
        } while(i%k == 0);
        return k;
    }
    public static int getPrime(int index) {
        return index < getLength() ? primes[index] : 2;
    }
    public static int getLength () {
        return primes.length;
    }
}
