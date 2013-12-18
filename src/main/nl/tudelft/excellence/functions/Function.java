package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

public abstract class Function {
	public Function(int MIN_ARGS, String... values) throws IllegalFunctionArgumentsException{
		if(values.length<MIN_ARGS){
			throw new IllegalFunctionArgumentsException("Insufficient arguments supplied. Need at least "+MIN_ARGS+".");
		} else {
			System.out.println(MIN_ARGS);
		}
	}
}
