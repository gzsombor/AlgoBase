/**
 * 
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
