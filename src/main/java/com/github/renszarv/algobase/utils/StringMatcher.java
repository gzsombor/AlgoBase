package com.github.renszarv.algobase.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class to help iterating over substrings in a string, returning the positions of it.
 * For example :
 * <pre>
 *  for (Integer pos : new StringMatcher("abcbabc", "ab")) {
 *    System.out.println(pos);
 *  }
 * </pre>
 * Will result in
 * <pre>
 *  0
 *  4
 * </pre>
 * @author zsombor
 *
 */
public class StringMatcher implements Iterable<Integer> {
	final String string;
	final String find;

	public StringMatcher(String string, String find) {
		super();
		this.string = string;
		this.find = find;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new StringMatcherIterator();
	}

	private class StringMatcherIterator implements Iterator<Integer> {
		int nextMatch;

		StringMatcherIterator() {
			super();
			nextMatch = string.indexOf(find);
		}

		@Override
		public boolean hasNext() {
			return nextMatch != -1;
		}

		@Override
		public Integer next() {
			if (nextMatch != -1) {
				Integer result = nextMatch;
				nextMatch = string.indexOf(find, nextMatch + 1);
				return result;
			} else {
				throw new NoSuchElementException();
			}
		}
	}

}