package com.sebskyo.encryptinator.algorithms;

import java.util.Iterator;

/**
 * Author: Sebastian Vikkelsø Elleholm
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
