package com.github.renszarv.algobase.graph;
import static org.junit.Assert.*;

import org.junit.Test;

public class CircleFindingInGraphTest {

	@Test
	public void findLongestCircle() {
		Graph g = buildGraph();
		
		Optimum maximumPath =g.optimize(Maximum.circle());
		assertNotNull("maximumPath", maximumPath);
		assertEquals(330, maximumPath.getCurrentOptimum());
		int[] path = maximumPath.getOptimalPath();
		assertEquals(330, g.walkRound(path));
		assertEquals("David -> Carol -> Bob -> Alice", g.describe(path));
	}

	@Test
	public void findShortestCircle() {
		Graph g = buildGraph();
		
		Optimum minimumPath =g.optimize(Minimum.circle());
		assertNotNull("minimumPath", minimumPath);
		assertEquals(-114, minimumPath.getCurrentOptimum());
		int[] path = minimumPath.getOptimalPath();
		assertEquals(-114, g.walkRound(path));
		assertEquals("David -> Bob -> Carol -> Alice", g.describe(path));
	}

	
	public Graph buildGraph() {
		Graph g = new Graph();
		g.addDistance("Alice", "Bob", 54);
		g.addDistance("Alice", "Carol", -79);
		g.addDistance("Alice", "David", -2);
		g.addDistance("Bob", "Alice", 83);
		g.addDistance("Bob", "Carol", -7);
		g.addDistance("Bob", "David", -63);
		g.addDistance("Carol", "Alice", -62);
		g.addDistance("Carol", "Bob", 60);
		g.addDistance("Carol", "David", 55);
		g.addDistance("David", "Alice", 46);
		g.addDistance("David", "Bob", -7);
		g.addDistance("David", "Carol", 41);
		g.finish();

		return g;
	}
}
