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

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Return all the permutation for a given size.
 * 
 * <code>
 *    PermutationIterator p = new PermutationIterator(3);
 *    p.next() == [ 2, 1, 0]
 *    p.next() == [ 2, 0, 1]
 *    p.next() == [ 1, 2, 0]
 *    p.next() == [ 1, 0, 2]
 *    p.next() == [ 0, 2, 1]
 *    p.next() == [ 0, 1, 2]
 *  </code>
 * 
 * @author zsombor
 * 
 */
public class PermutationIterator implements Iterator<int[]> {

	protected int size;
	protected FactorialIterator fact;
	private int[] factorial;

	/**
	 * 
	 */
	public PermutationIterator(int size) {
		this.size = size;
		this.factorial = new int[size];
		this.fact = new FactorialIterator(size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return fact.hasNext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	public int[] next() {
		int[] result = new int[size];
		convertInto(result);
		return result;
	}

	/**
	 * Fill the array with next permutation, this can be used, if it's
	 * unnecessary to create new result arrays.
	 * 
	 * @param result
	 */
	public void getNextPermutationInto(int[] result) {
		Utils.validateArrayLength(size, result);
		convertInto(result);
	}

	protected void convertInto(int[] result) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		fact.getTheNext(factorial);
		for (int i = 0; i < size; i++) {
			linkedList.addLast(i);
		}
		for (int i = 0; i < size; i++) {
			result[i] = linkedList.remove(factorial[size - i - 1]);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
