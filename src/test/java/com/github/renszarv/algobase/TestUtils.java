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

import org.junit.Assert;

/**
 * @author zsombor
 *
 */
public class TestUtils {
	public static void check(Iterator<int[]> p, int... expected) {
		String label = pretty(expected);
		Assert.assertTrue("has " + label, p.hasNext());
		int[] actual = p.next();
		Assert.assertEquals(label, pretty(actual));
		Assert.assertArrayEquals(label, expected, actual);
	}
	
	public static void check(int[] actual, int... expected) {
		String label = pretty(expected);
		Assert.assertEquals(label, pretty(actual));
		Assert.assertArrayEquals(label, expected, actual);
	}

	public static String pretty(int[] array) {
		StringBuilder lb = new StringBuilder("(");
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				lb.append(",");
			}
			lb.append(array[i]);
		}
		return lb.append(')').toString();
	}

}
