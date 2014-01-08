package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Checks if a given String is a representation of a logical value
 * <b>Syntax:</b> ISLOGICAL(String value) 
 */
public class ISLOGICAL extends BooleanFunction{
	private String value;
	
	final static int MIN_ARGS = 1;
	
	public ISLOGICAL(String input) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, input);
		value = input.trim();
	}

	@Override
	public boolean execute() {
		return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");
	}
}
