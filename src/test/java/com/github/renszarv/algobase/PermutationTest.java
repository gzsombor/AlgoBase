/**
 * 
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
