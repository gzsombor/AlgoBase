package com.github.renszarv.algobase;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class PartitionIteratorTest {

	@Test
	public void testPartitionOf3() {
		PartitionIterator p = new PartitionIterator(3);
		check(p, 1, 1, 1);
		check(p, 1, 2);
		check(p, 3);
	}

	@Test
	public void testPartitionOf5() {
		PartitionIterator p = new PartitionIterator(5);
		check(p, 1, 1, 1, 1, 1);
		check(p, 1, 1, 1, 2);
		check(p, 1, 1, 3);
		check(p, 1, 2, 2);
		check(p, 1, 4);
		check(p, 2, 3);
		check(p, 5);
	}

	public static void check(Iterator<int[]> p, int... expected) {
		String label = pretty(expected);
		Assert.assertTrue("has " + label, p.hasNext());
		int[] actual = p.next();
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
