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
		try{
			input = Boolean.parseBoolean(value);
		}
		catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	}


	@Override
	public boolean execute() {
		return !input;
	}
}