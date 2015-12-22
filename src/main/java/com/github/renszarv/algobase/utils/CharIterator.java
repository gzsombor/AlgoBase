package com.github.renszarv.algobase.utils;

import java.util.Iterator;

/**
 * {@link Iterator}, which returns the individual characters from a {@link String}
 * 
 * @author zsombor
 *
 */
public class CharIterator implements Iterator<Character> {
    private final String string;
    private int pos = 0;
    
    public CharIterator(String string) {
        this.string = string;
    }
    @Override
    public boolean hasNext() {
        return pos < string.length();
    }
    @Override
    public Character next() {
        return string.charAt(pos++);
    }
    
}