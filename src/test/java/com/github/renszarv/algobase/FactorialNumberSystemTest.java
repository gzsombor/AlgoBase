package com.github.renszarv.algobase;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
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

}
