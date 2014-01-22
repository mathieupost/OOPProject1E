package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

public abstract class NumberFunction extends Function {
	public NumberFunction(int MIN_ARGS, String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
	}

	/**
	 * Execute this function and return the resulting double
	 * @return The double result of the function
	 */
	public abstract double execute();
}
