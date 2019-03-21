package com.github.renszarv.algobase;

import java.util.Arrays;

/**
 * Class which iteratively checks all the combination, where in all the posib
 * @author zsombor
 *
 */
public class Combinator {

	private final int[] max;
	private int[] current;
	
	public Combinator(int... max) {
		this.max = max;
		current = new int[max.length];
	}
	
	public void copyCurrent(int[] result) {
		System.arraycopy(current, 0, result, 0, current.length);
	}
	
	public boolean inc() {
		for (int i=0;i<max.length;i++) {
			current[i] ++;
			if (current[i] < max[i]) {
				return true;
			} else {
				current[i] = 0;
			}
		}
		return false;
	}
	
	
	
	public static Combinator createArray(int length, int value) {
		int[] maxes = new int[length];
		Arrays.fill(maxes, value);
		return new Combinator(maxes);
	}
	
	
	
}
