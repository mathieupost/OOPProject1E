package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Converts a String into all lowercase letters
 * <b>Syntax:</b> LOWER(String value)
 */
public class LOWER extends StringFunction{

	private String lower;
	final static int MIN_ARGS = 1;
	final static int MAX_ARGS = 1;

	public LOWER(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, MAX_ARGS, values);
		lower = values[0];
	}

	@Override
	public String execute() {
		return lower.toLowerCase();
	}
}
