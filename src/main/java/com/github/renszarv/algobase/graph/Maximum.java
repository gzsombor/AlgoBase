package com.github.renszarv.algobase.graph;

public class Maximum extends Optimum {

	public static Optimum path () { 
		return new Maximum(false);
	}
	public static Optimum circle() {
		return new Maximum(true);
	}

	private Maximum(boolean circle) {
		super(Integer.MIN_VALUE, circle);
	}

	@Override
	protected boolean better(int currentScore) {
		return currentScore > currentOptimum;
	}
}