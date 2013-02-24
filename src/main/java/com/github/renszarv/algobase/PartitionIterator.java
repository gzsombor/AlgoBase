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
