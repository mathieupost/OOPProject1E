package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

public abstract class Function {
	public Function(int MIN_ARGS, int MAX_ARGS, String... values) throws IllegalFunctionArgumentsException {
		if (values.length < MIN_ARGS) {
			throw new IllegalFunctionArgumentsException("Need at least " + MIN_ARGS + " arguments");
		} else if (MAX_ARGS >= MIN_ARGS && values.length > MAX_ARGS) {
			throw new IllegalFunctionArgumentsException("Only accepts a maximum of " + MAX_ARGS + " arguments");
		}
	}
}
