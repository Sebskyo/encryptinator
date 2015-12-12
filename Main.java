package com.sebskyo.encryptinator;

import com.sebskyo.encryptinator.algorithms.Prime;
import com.sebskyo.encryptinator.algorithms.KeySet;

/**
 * Encryptinator(tm)
 * Author: Sebastian Vikkelsø Elleholm
 */
public class Main {
    public static void main (String[] args) {
        KeySet key = new KeySet(25);
        key.printInfo();
    }
}
