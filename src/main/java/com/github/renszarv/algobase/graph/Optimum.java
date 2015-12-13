package com.github.renszarv.algobase.graph;

public abstract class Optimum {
	protected int[] optimalPath;
    protected int currentOptimum;
    private boolean circle;
    
    
    protected Optimum(int currentOptimum, boolean circle) {
        this.currentOptimum = currentOptimum;
        this.circle = circle;
    }

    public boolean nextPath(Graph graph, int[] path) {
        int currentScore = circle ? graph.walkRound(path) : graph.walk(path);
        if (better(currentScore)) {
            optimalPath = path;
            currentOptimum = currentScore;
            return true;
        }
        return false;
    }
    
    abstract protected boolean better(int currentScore);

    public int getCurrentOptimum() {
		return currentOptimum;
	}
    
    public int[] getOptimalPath() {
		return optimalPath;
	}
    
}