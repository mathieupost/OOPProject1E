package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

public abstract class Function {
	public Function(int MIN_ARGS, String... values) throws IllegalFunctionArgumentsException {
		if (values.length < MIN_ARGS) {
			throw new IllegalFunctionArgumentsException("Need at least " + MIN_ARGS + " arguments");
		}
	}
}
