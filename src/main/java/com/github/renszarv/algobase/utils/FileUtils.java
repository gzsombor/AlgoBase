package com.github.renszarv.algobase.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileUtils {

	/**
	 * Helper method for validating input, useful when there is a known 'filler'
	 * word is expected. It throws an {@link IllegalArgumentException} when the
	 * tokenizer doesn't return the expected token.
	 *
	 * @param line
	 *            the whole input line - needed for better error message.
	 * @param token
	 *            the {@link StringTokenizer} which contains the line
	 * @param expected
	 *            the expected token.
	 */
	public static void expect(String line, StringTokenizer token, String expected) {
		String to = token.nextToken();
		if (!expected.equals(to)) {
			throw new IllegalArgumentException("'" + expected + "' expected, found: " + to + " in " + line);
		}
	}

	/**
	 * Consume a file, which is given as the first parameter and feed the
	 * lineProcessor with the lines in it.
	 * 
	 * @param filename
	 * @param lineProcessor
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void consumeFile(String filename, Consumer<String> lineProcessor)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		try (BufferedReader reader = createFileReader(filename)) {
			reader.lines().forEach(lineProcessor);
		}
	}

	/**
	 * Reads a file, line by line, and feeds to the lineProcessor, and returns
	 * the list of objects which returned by that processor.
	 * 
	 * @param filename
	 * @param lineProcessor
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static <X> List<X> processFile(String filename, Function<String, X> lineProcessor)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		try (BufferedReader reader = createFileReader(filename)) {

			return reader.lines().map(lineProcessor).collect(Collectors.toList());

		}
	}

	/**
	 * Returns a {@link BufferedReader} which reads from the given file.
	 *
	 * @param filename
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	public static BufferedReader createFileReader(String filename)
			throws UnsupportedEncodingException, FileNotFoundException {
		return new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
	}

}
