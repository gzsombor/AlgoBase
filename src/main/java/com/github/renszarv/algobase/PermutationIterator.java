/**
 * 
 */
package com.github.renszarv.algobase;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Return all the permutation for a given size.
 * 
 *  <code>
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
	 * Fill the array with next permutation, this can be used, 
	 * if it's unnecessary to create new result arrays.
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
		for (int i = 0;i < size; i++) {
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
