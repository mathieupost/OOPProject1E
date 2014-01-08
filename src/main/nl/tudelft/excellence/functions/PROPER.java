package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Converts a text string to proper case; the first letter in each word in uppercase, and all other letters to lowercase.
 * <b>Syntax:</b> PROPER(String input)
 */

public class PROPER extends StringFunction{
	
	private String proper;
	
	final static int MIN_ARGS = 1;
	
	public PROPER(String input) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, input);
		proper = input;
	}

	@Override
	public String execute() {
		StringBuilder b = new StringBuilder(proper.toLowerCase());
		int i = 0;
		do {
			b.replace(i, i + 1, b.substring(i,i + 1).toUpperCase());
			i =  b.indexOf(" ", i) + 1;
		} while (i > 0 && i < b.length());
		return b.toString();
	}

}
