package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

public abstract class StringFunction extends Function {
	public StringFunction(int MIN_ARGS, int MAX_ARGS, String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, MAX_ARGS, values);
	}

	//TODO: Uncomment if a StringFunction ever needs this
	/*public StringFunction(int MIN_ARGS, String... values) throws  IllegalFunctionArgumentsException{
		super(MIN_ARGS, 0, values);
	}*/

	/**
	 * Execute this function and return the resulting String
	 * @return The String result of the function
	 */
	public abstract String execute();
}