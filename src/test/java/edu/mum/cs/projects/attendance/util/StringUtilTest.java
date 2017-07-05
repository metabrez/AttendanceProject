package edu.mum.cs.projects.attendance.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {
	
	private static final String BAD_RETURN = "Method did not produce the expected result";

	@Test
	public void testProperCase() {
		String input1 = " john doe ";
		String input2 = "JOHN DOE";
		String output = "John Doe";
		assertNull(BAD_RETURN, StringUtil.properCase(null));
		assertTrue(BAD_RETURN, StringUtil.properCase("").isEmpty());
		assertTrue(BAD_RETURN, StringUtil.properCase(" ").isEmpty());
		assertTrue(BAD_RETURN, output.equals(StringUtil.properCase(input1)));
		assertTrue(BAD_RETURN, output.equals(StringUtil.properCase(input2)));
	}

}
