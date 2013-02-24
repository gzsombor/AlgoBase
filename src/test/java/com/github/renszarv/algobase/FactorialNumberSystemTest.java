package com.github.renszarv.algobase;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialNumberSystemTest {
	@Test
	public void factorialNumbersOfSize2() {
		FactorialIterator p = new FactorialIterator(2);
		PartitionIteratorTest.check(p, 0, 1);
		PartitionIteratorTest.check(p, 0, 0);
		assertFalse("no more, just 2", p.hasNext());
	}

	@Test
	public void factorialNumbersOfSize3() {
		FactorialIterator p = new FactorialIterator(3);
		PartitionIteratorTest.check(p, 0, 1, 2);
		PartitionIteratorTest.check(p, 0, 0, 2);
		PartitionIteratorTest.check(p, 0, 1, 1);
		PartitionIteratorTest.check(p, 0, 0, 1);
		PartitionIteratorTest.check(p, 0, 1, 0);
		PartitionIteratorTest.check(p, 0, 0, 0);
		assertFalse("no more, just 6", p.hasNext());
	}
	
}
