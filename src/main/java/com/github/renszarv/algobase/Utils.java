package com.github.renszarv.algobase;

public class Utils {

	private Utils() {
	}

	public static void validateArrayLength(int size, int[] array) {
		if (array.length != size) {
			throw new IllegalArgumentException(
					"expected an array with a length of " + size
							+ ", received : " + array.length);
		}
	}
}
