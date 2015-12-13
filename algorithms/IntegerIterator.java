package com.sebskyo.encryptinator.algorithms;

import java.util.Iterator;

/**
 * The IntegerIterator class always returns the next integer, for use in generating primes
 */
class IntegerIterator implements Iterator<Integer> {

	private int current = 1;

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		return ++current;
	}

	@Override
	public void remove() {

	}
}
