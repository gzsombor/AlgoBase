package com.github.renszarv.algobase.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

import com.github.renszarv.algobase.PermutationIterator;


/**
 * Simple, inefficient undirected graph implementation.
 * 
 * @author zsombor
 *
 */
public class Graph {
    private boolean finished = false;
    private final Set<String> locations = new TreeSet<>();
    private String[] locationOrder;
    private final Map<String, Map<String, Integer>> positions = new HashMap<>();

    /**
     * Sets the distance between the two points.
     * 
     * @param a
     * @param b
     * @param distance
     */
    public void setDistance(String a, String b, Integer distance) {
        changeDistance(a, b, (x) -> distance);
    }

    /**
     * Increase the distance between the two points - it assumes 0, if nothing specified before.
     * 
     * @param a 
     * @param b
     * @param distance
     */
    public void addDistance(String a, String b, Integer distance) {
        changeDistance(a, b, (x) -> x != null ? x.intValue() + distance.intValue() : distance.intValue());
    }

    /**
     * Changes the distance between the two points with the given function.
     * 
     * @param a
     * @param b
     * @param distanceChanger
     */
    public void changeDistance(String a, String b, Function<Integer, Integer> distanceChanger) {
        if (finished) {
            throw new IllegalArgumentException("Graph already finished");
        }
        locations.add(a);
        locations.add(b);
        int cmp = a.compareTo(b);
        if (cmp == 0) {
            throw new IllegalArgumentException("Distance from self? " + a + " - " + b + " :" + distanceChanger.apply(null));
        }
        if (cmp > 0) {
            putPosition(a, b, distanceChanger);
        } else {
            putPosition(b, a, distanceChanger);
        }
    }
    
    private void putPosition(String a, String b, Function<Integer, Integer> distanceChanger) {
        Map<String, Integer> p = positions.get(a);
        if (p == null) {
            p = new HashMap<>();
            positions.put(a, p);
        }
        p.put(b, distanceChanger.apply(p.get(b)));
    }

    public int getDistance(String a, String b) {
        int cmp = a.compareTo(b);
        if (cmp == 0) {
            throw new IllegalArgumentException("Distance from self? " + a + " - " + b);
        }
        if (cmp > 0) {
            return getPosition(a, b);
        } else {
            return getPosition(b, a);
        }

    }

    /**
     * @return a Set of location names.
     */
    public Set<String> getLocations() {
        return new HashSet<>(locations);
    }
    
    private int getPosition(String a, String b) {
        Map<String, Integer> p = positions.get(a);
        if (p != null) {
            Integer dist = p.get(b);
            if (dist == null) {
                throw new IllegalArgumentException("Not found distance:" + b + " in " + p);
            }
            return dist.intValue();
        } else {
            throw new IllegalArgumentException("Not found start position:" + a + " in " + positions);
        }
    }
    
    public void finish() {
        finished = true;
        locationOrder = locations.toArray(new String[locations.size()]);
    }
    
    public int size() {
        if (!finished) {
            throw new IllegalArgumentException("Graph not finished yet");
        }
        return locationOrder.length;
    }
    
    @Override
    public String toString() {
        return positions.toString();
    }
    
    /**
     * Calculate the score of the walking through given path.
     * 
     * @param path
     * @return
     */
    public int walk(int[] path) {
        if (!finished) {
            throw new IllegalArgumentException("Graph not finished yet");
        }
        String current = locationOrder[path[0]];
        int length = 0;
        for (int i=1;i<path.length;i++) {
            String next = locationOrder[path[i]];
            length += getDistance(current, next);
            current = next;
        }
        return length;
    }

    /**
     * Calculate the score of the walking through given path, assuming that after the last point, we return to the first location.
     * 
     * @param path
     * @return
     */
    public int walkRound(int[] path) {
    	int length = walk(path);
        length += getDistance(locationOrder[path[path.length - 1]], locationOrder[path[0]]);
        return length;
    }

    /**
     * Describes the given path separated by ' -> '.
     * @param path
     * @return
     */
    public String describe(int[] path) {
        StringBuilder b = new StringBuilder();
        String current = locationOrder[path[0]];
        b.append(current);
        for (int i=1;i<path.length;i++) {
            String next = locationOrder[path[i]];
            b.append(" -> ").append(next);
        }            
        return b.toString();
    }
    
    public int[] probe(Optimum opt) {
    	return optimize(opt).getOptimalPath();
    }

    /**
     * Optimize to the given condition, and return the best solution. This is an o(n!) call, not suitable for large graphs.
     * @param opt
     * @return
     */
    public Optimum optimize(Optimum opt) {
        PermutationIterator p = new PermutationIterator(size());
        while(p.hasNext()) {
            int[] path = p.next();
            if (opt.nextPath(this, path)) {
            	foundBetterPath(path);
                //System.out.println(describe(path) + " = " +walk(path));
            }
        }
        return opt;
    }
    
    /**
     * Callback, which gets called when in the optimization, a better path is found. 
     * @param path
     */
    public void foundBetterPath(int[] path) {
    	
    }
    
}