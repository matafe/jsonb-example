package com.matafe.jsonbexample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class TestUtils {

	public static String getTestFileContent(final String fileName) throws Exception {
		String text;
		final InputStream in = TestUtils.class.getClassLoader().getResourceAsStream(fileName);
		if (in == null) {
			throw new IllegalArgumentException("File " + fileName + " not found on test resources!");
		}
		try (final BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
			text = reader.lines().collect(Collectors.joining("\n"));
		}
		return text;
	}

}
