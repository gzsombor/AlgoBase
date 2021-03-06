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

import org.junit.Test;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import static com.github.renszarv.algobase.TestUtils.check;

public class FactorialNumberSystemTest {
	@Test
	public void factorialNumbersOfSize2() {
		FactorialIterator p = new FactorialIterator(2);
		check(p, 0, 1);
		check(p, 0, 0);
		assertFalse("no more, just 2", p.hasNext());
	}

	@Test
	public void factorialNumbersOfSize3() {
		FactorialIterator p = new FactorialIterator(3);
		check(p, 0, 1, 2);
		check(p, 0, 0, 2);
		check(p, 0, 1, 1);
		check(p, 0, 0, 1);
		check(p, 0, 1, 0);
		check(p, 0, 0, 0);
		assertFalse("no more, just 6", p.hasNext());
	}

	@Test
	public void factorialNumbersOfSize3Skip1() {
		FactorialIterator p = new FactorialIterator(3, 2);
		check(p,  1, 2);
		check(p,  0, 2);
		check(p,  1, 1);
		check(p,  0, 1);
		check(p,  1, 0);
		check(p,  0, 0);
		assertFalse("no more, just 6", p.hasNext());
	}

	@Test
	public void factorialNumbersOfMaximum4Length2() {
		FactorialIterator p = new FactorialIterator(4, 2);
		check(p,  2, 3);
		check(p,  1, 3);
		check(p,  0, 3);
		check(p,  2, 2);
		check(p,  1, 2);
		check(p,  0, 2);
		check(p,  2, 1);
		check(p,  1, 1);
		check(p,  0, 1);
		check(p,  2, 0);
		check(p,  1, 0);
		check(p,  0, 0);
		assertFalse("no more, just 12", p.hasNext());
	}

}
