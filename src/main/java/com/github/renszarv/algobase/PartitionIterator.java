/**
 * 
 */
package com.github.renszarv.algobase;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Based on http://homepages.ed.ac.uk/jkellehe/partitions.php
 * 
 * @author zsombor
 * 
 */
public class PartitionIterator implements Iterator<int[]> {

	final int sum;
	final int[] a;
	int k;

	public PartitionIterator(int sum) {
		this.sum = sum;
		a = new int[sum + 1];
		k = 1;
		a[1] = sum;
	}

	public boolean hasNext() {
		return k != 0;
	}

	public int[] next() {
		int x = a[k - 1] + 1;
		int y = a[k] - 1;
		k--;
		while (x <= y) {
			a[k] = x;
			y -= x;
			k++;
		}
		a[k] = x + y;
		return Arrays.copyOf(a, k + 1);
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
