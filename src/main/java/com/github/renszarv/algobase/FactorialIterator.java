/**
 * 
 */
package com.github.renszarv.algobase;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * Return all the factorial numbers in a descending order, for a given size.
 *  For example: 
 *  <code>
 *    FactorialIterator f = new FactorialIterator(3);
 *    f.next() == [ 0, 1, 2]
 *    f.next() == [ 0, 0, 2]
 *    f.next() == [ 0, 1, 1]
 *    f.next() == [ 0, 0, 1]
 *    f.next() == [ 0, 1, 0]
 *    f.next() == [ 0, 0, 0]
 *  </code>
 *  
 *  This used to generate all the permutation. 
 *  More on factorial number system :
 *   http://en.wikipedia.org/wiki/Factorial_number_system
 *  
 * @author zsombor
 * 
 */
public class FactorialIterator implements Iterator<int[]> {
	final int size;
	BigInteger actual;

	public FactorialIterator(int size) {
		this.size = size;
		actual = Factorials.getInstance().nth(size).subtract(BigInteger.ONE);
	}

	public boolean hasNext() {
		return actual.compareTo(BigInteger.ZERO) >= 0;
	}

	public int[] next() {
		int[] result = new int[size];
		convertInto(result);
		return result;
	}

	/**
	 * Fill the given array with the next factorial number.
	 * @param result
	 */
	public void getTheNext(int[] result) {
		if (result.length != size) {
			throw new IllegalArgumentException(
					"expected an array with a length of " + size
							+ ", received : " + result.length);
		}
		convertInto(result);
	}

	protected synchronized void convertInto(int[] result) {
		BigInteger current = actual;
		Factorials f = Factorials.getInstance();
		for (int i = size - 1; i >= 0; i--) {
			BigInteger nth = f.nth(i);
			BigInteger[] divideAndRemainder = current.divideAndRemainder(nth);
			result[i] = divideAndRemainder[0].intValue();
			current = divideAndRemainder[1];
		}
		actual = actual.subtract(BigInteger.ONE);
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
