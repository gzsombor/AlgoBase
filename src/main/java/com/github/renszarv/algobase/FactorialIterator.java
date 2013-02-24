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
		Utils.validateArrayLength(size, result);		
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
