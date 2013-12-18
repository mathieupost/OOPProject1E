package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

public abstract class StringFunction extends Function {
	public StringFunction(int MIN_ARGS, String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
	}
	
	/**
	 * Execute this function and return the resulting String
	 * @return The String result of the function
	 */
	public abstract String execute();
}