package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * This function checks if a given String is a number
 * <b>Sytax:</b> ISNUMBER(String value)
 */

public class ISNUMBER extends BooleanFunction{
	final static int MIN_ARGS = 1;
	
	private String input;
	
	public ISNUMBER(String value) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, value);
		input = value;
		
	}

	@Override
	public boolean execute() {
		try {
			Double.parseDouble(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
