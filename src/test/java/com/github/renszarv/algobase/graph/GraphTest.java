package com.github.renszarv.algobase.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testMinimumPath1() {
		Graph g = buildSimpleGraph();
		
		int[] minimumPath =g.probe(Minimum.path());
		
		String path = g.describe(minimumPath);
		int score = g.walk(minimumPath);
		assertEquals(464+141, score);
		assertEquals("London -> Dublin -> Belfast", path);
	}

	@Test
	public void testMaximumPath1() {
		Graph g = buildSimpleGraph();
		
		int[] minimumPath =g.probe(Maximum.path());
		
		String path = g.describe(minimumPath);
		int score = g.walk(minimumPath);
		assertEquals(464+518, score);
		assertEquals("Dublin -> London -> Belfast", path);
	}

	@Test
	public void testMinimumPath2() {
		Graph g = buildBiggerGraph();
		
		Optimum minimumPath =g.optimize(Minimum.path());
		
		String path = g.describe(minimumPath.getOptimalPath());
		int score = g.walk(minimumPath.getOptimalPath());
		assertEquals(251, score);
		assertEquals(251, minimumPath.getCurrentOptimum());
		assertEquals("Tambi -> Arbre -> Snowdin -> AlphaCentauri -> Tristram -> Straylight -> Faerun -> Norrath", path);
	}

	@Test
	public void testMaximumPath2() {
		Graph g = buildBiggerGraph();
		
		Optimum minimumPath =g.optimize(Maximum.path());
		
		String path = g.describe(minimumPath.getOptimalPath());
		assertEquals(898, minimumPath.getCurrentOptimum());
		int score = g.walk(minimumPath.getOptimalPath());
		assertEquals(898, score);
		assertEquals("Tristram -> Faerun -> Arbre -> Straylight -> AlphaCentauri -> Norrath -> Tambi -> Snowdin", path);
	}

	
	private Graph buildSimpleGraph() {
		Graph g = new Graph();

		g.addDistance("London", "Dublin", 464);
		g.addDistance("London", "Belfast", 518);
		g.addDistance("Dublin", "Belfast", 141);

		g.finish();
		return g;
	}
	


	private Graph buildBiggerGraph() {
		Graph g = new Graph();
		g.addDistance("Tristram","AlphaCentauri",34);
		g.addDistance("Tristram","Snowdin",100);
		g.addDistance("Tristram","Tambi",63);
		g.addDistance("Tristram","Faerun",108);
		g.addDistance("Tristram","Norrath",111);
		g.addDistance("Tristram","Straylight",89);
		g.addDistance("Tristram","Arbre",132);
		g.addDistance("AlphaCentauri","Snowdin",4);
		g.addDistance("AlphaCentauri", "Tambi",79);
		g.addDistance("AlphaCentauri","Faerun", 44);
		g.addDistance("AlphaCentauri","Norrath", 147);
		g.addDistance("AlphaCentauri","Straylight", 133);
		g.addDistance("AlphaCentauri","Arbre", 74);
		g.addDistance("Snowdin","Tambi", 105);
		g.addDistance("Snowdin","Faerun", 95);
		g.addDistance("Snowdin","Norrath", 48);
		g.addDistance("Snowdin","Straylight", 88);
		g.addDistance("Snowdin","Arbre", 7);
		g.addDistance("Tambi","Faerun", 68);
		g.addDistance("Tambi","Norrath", 134);
		g.addDistance("Tambi","Straylight", 107);
		g.addDistance("Tambi","Arbre", 40);
		g.addDistance("Faerun","Norrath", 11);
		g.addDistance("Faerun","Straylight", 66);
		g.addDistance("Faerun","Arbre", 144);
		g.addDistance("Norrath","Straylight", 115);
		g.addDistance("Norrath","Arbre", 135);
		g.addDistance("Straylight","Arbre", 127);
		
		g.finish();
		return g;
	}
	
}
