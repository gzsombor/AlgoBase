package com.github.renszarv.algobase.graph;

public class Minimum extends Optimum {
	public static Optimum path () { 
		return new Minimum(false);
	}
	public static Optimum circle() {
		return new Minimum(true);
	}
	
	
    private Minimum(boolean circle) {
        super(Integer.MAX_VALUE, circle);
    }
    
    @Override
    protected boolean better(int currentScore) {
        return currentScore < currentOptimum;
    }
}