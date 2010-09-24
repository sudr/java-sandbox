package org.sudr.sandbox.reverser;

public class StringReverser implements Reverser<String> {

	public String reverse(String input) {
		if (input == null || input.length() < 2)
			return input;
		
		return reverse(input.substring(1)) + input.charAt(0);
	}

}
