package com.sebskyo.encryptinator;

import com.sebskyo.encryptinator.algorithms.Prime;
import com.sebskyo.encryptinator.algorithms.KeySet;

/**
 * Encryptinator(tm)
 * Author: Sebastian Vikkelsø Elleholm
 */
public class Main {
    public static void main (String[] args) {
        Prime.generatePrimes(10);
        KeySet key = new KeySet();
        key.printInfo();
        //System.out.println(Utility.inverse(new int[][]{{44, 44},{17, 1}},44)[1][1]);
    }
}
