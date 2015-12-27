/*
 * Copyright (c) 2013, Zsombor Gegesy
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions 
 * are met:
 * 
 *  - Redistributions of source code must retain the above copyright 
 *      notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer 
 *      in the documentation and/or other materials provided with the distribution.
 *  
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 *  AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 *  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 *  ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 *  LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 *  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 *  INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 *  CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 *  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF 
 *  THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.renszarv.algobase;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * Return all the factorial numbers in a descending order, for a given size.
 *  For example: 
 *  <pre>
 *    FactorialIterator f = new FactorialIterator(3);
 *    f.next() == [ 0, 1, 2]
 *    f.next() == [ 0, 0, 2]
 *    f.next() == [ 0, 1, 1]
 *    f.next() == [ 0, 0, 1]
 *    f.next() == [ 0, 1, 0]
 *    f.next() == [ 0, 0, 0]
 *  </pre>
 *  
 *  This used to generate all the permutation. 
 *  More on factorial number system :
 *   http://en.wikipedia.org/wiki/Factorial_number_system
 *  It is also possible to generate all permutation ending, where the length, and maximal number is different, for example:
 *  
 *   <pre>
 *    FactorialIterator f = new FactorialIterator(4,2);
 *    f.next() == [ 2, 3]
 *    f.next() == [ 1, 3]
 *    f.next() == [ 0, 3]
 *    f.next() == [ 2, 2]
 *    f.next() == [ 1, 2]
 *    f.next() == [ 0, 2]
 *    f.next() == [ 2, 1]
 *    f.next() == [ 1, 1]
 *    f.next() == [ 0, 1]
 *    f.next() == [ 2, 0]
 *    f.next() == [ 1, 0]
 *    f.next() == [ 0, 0]
 *  </pre>
 *  
 * @author zsombor
 * 
 */
public class FactorialIterator implements Iterator<int[]> {
	private final int maximum;
	private final int skipLast;
	private BigInteger actual;

	public FactorialIterator(int maximum) {
		this(maximum, maximum);
	}

	public FactorialIterator(int maximum, int length) {
		if (length > maximum) {
			throw new IllegalArgumentException("maximum >= length");
		}
		if (length < 0) {
			throw new IllegalArgumentException("length < 0");
		}
		this.maximum = maximum;
		this.skipLast = maximum - length;
		actual = Factorials.getInstance().nth(maximum).subtract(BigInteger.ONE);
	}

	public boolean hasNext() {
		return actual.compareTo(BigInteger.ZERO) >= 0;
	}

	public int[] next() {
		int[] result = new int[maximum - skipLast];
		convertInto(result);
		return result;
	}

	/**
	 * Fill the given array with the next factorial number.
	 * @param result
	 */
	public void getTheNext(int[] result) {
		Utils.validateArrayLength(maximum - skipLast, result);		
		convertInto(result);
	}

	protected synchronized void convertInto(int[] result) {
		BigInteger current = actual;
		Factorials f = Factorials.getInstance();
		for (int i = maximum - 1; i >= skipLast; i--) {
			BigInteger nth = f.nth(i);
			BigInteger[] divideAndRemainder = current.divideAndRemainder(nth);
			result[i- skipLast] = divideAndRemainder[0].intValue();
			current = divideAndRemainder[1];
		}
		actual = actual.subtract(f.nth(skipLast));
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
