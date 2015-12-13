package com.sebskyo.encryptinator.algorithms;

import java.util.Iterator;

/**
 * Author: Sebastian Vikkelsø Elleholm
 */
class FilterIterator implements Iterator<Integer> {

	private Iterator<Integer> iterator;
	private int filter;

	public FilterIterator(Iterator<Integer> iterator, int filter) {
		this.iterator = iterator;
		this.filter = filter;
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		Integer next;

		do {
			next = iterator.next();
		} while (next % filter == 0);
		return next;
	}

	@Override
	public void remove() {

	}
}
