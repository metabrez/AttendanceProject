package edu.mum.cs.projects.attendance.util;

public class StringUtil {
	
	public static String properCase(String name) {
		
		if(null == name) {
			return null;
		}
		
		if(name.trim().isEmpty()) {
			return name.trim();
		}
		
		char[] chars = name.trim().toCharArray();
		char[] result = new char[chars.length];
		
		int index = 0;
		boolean toUpper = true;
		for(char c : chars) {
			if(toUpper) {
				c = Character.toUpperCase(c);
				toUpper = false;
			}
			else {
				c = Character.toLowerCase(c);
			}
			
			if(' ' == c) {
				toUpper = true;
			}
			
			result[index++] = c;
		}
		
		return new String(result);
	}

}
