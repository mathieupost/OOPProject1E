package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

public abstract class NumberFunction extends Function {
	public NumberFunction(int MIN_ARGS, int MAX_ARGS, String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, MAX_ARGS, values);
	}

	public NumberFunction(int MIN_ARGS, String... values) throws  IllegalFunctionArgumentsException{
		super(MIN_ARGS, 0, values);
	}

	/**
	 * Execute this function and return the resulting double
	 * @return The double result of the function
	 */
	public abstract double execute();
}
