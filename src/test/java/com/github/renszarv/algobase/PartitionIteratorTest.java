package com.github.renszarv.algobase;

import static com.github.renszarv.algobase.TestUtils.check;

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


}
