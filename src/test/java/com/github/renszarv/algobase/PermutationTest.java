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

import static org.junit.Assert.*;
import static com.github.renszarv.algobase.TestUtils.check;

import org.junit.Test;

/**
 * @author zsombor
 *
 */
public class PermutationTest {


	@Test
	public void testPermutationOf2() {
		PermutationIterator p = new PermutationIterator(2);
		check(p, 1, 0);
		check(p, 0, 1);
		assertFalse("no more, just 2", p.hasNext());
	}

	@Test
	public void testPermutationOf3() {
		PermutationIterator p = new PermutationIterator(3);
		check(p, 2, 1, 0);
		check(p, 2, 0, 1);
		check(p, 1, 2, 0);
		check(p, 1, 0, 2);
		check(p, 0, 2, 1);
		check(p, 0, 1, 2);
		assertFalse("no more, just 6", p.hasNext());
	}
	
	@Test
	public void testGetNextPermutation() {
		PermutationIterator p = new PermutationIterator(3);
		int[] bigger = new int[4];
		try {
			p.getNextPermutationInto(bigger);
			fail();
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		}
		int[] result = new int[3];
		p.getNextPermutationInto(result);
		check(result, 2, 1, 0);
		p.getNextPermutationInto(result);
		check(result, 2, 0, 1);
		p.getNextPermutationInto(result);
		check(result, 1, 2, 0);
		p.getNextPermutationInto(result);
		check(result, 1, 0, 2);
		p.getNextPermutationInto(result);
		check(result, 0, 2, 1);
		p.getNextPermutationInto(result);
		check(result, 0, 1, 2);
		assertFalse("no more, just 6", p.hasNext());
	}
}
