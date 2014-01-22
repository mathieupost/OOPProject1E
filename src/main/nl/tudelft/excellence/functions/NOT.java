package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Return the NOT value
 * <b>Syntax:</b> NOT(boolean value)
 */
public class NOT extends BooleanFunction {
	
	boolean input;
	final static int MIN_ARGS = 1;
	
	public NOT(String value)throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, value);
		
		input = Boolean.parseBoolean(value);	

	}


	@Override
	public boolean execute() {
		return !input;
	}
}