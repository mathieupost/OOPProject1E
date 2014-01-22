package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

public abstract class BooleanFunction extends Function {
	public BooleanFunction(int MIN_ARGS, String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
	}
	
	/**
	 * Execute this function and return the resulting boolean
	 * @return The boolean result of the function
	 */
	public abstract boolean execute();
}
