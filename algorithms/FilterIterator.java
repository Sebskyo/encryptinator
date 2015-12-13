package com.sebskyo.encryptinator.algorithms;

import java.util.Iterator;

/**
 * The FilterIterator class is like the IntegerIterator, but only returns the next number of which the filter is not a divisor of
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
