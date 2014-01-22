package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Rounds a double down and converts that to an integer
 * <b>Syntax:</b> INT(double value)
 */

public class INT extends NumberFunction {
	final static int MIN_ARGS = 1;
	final static int MAX_ARGS = 1;
	
	private double result;
	
	public INT(String... values){
		super(MIN_ARGS, MAX_ARGS, values);
		
		try{
			result = Double.parseDouble(values[0]);
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException("Expected a number, but got: "+values[0]);
		}
	}

	@Override
	public double execute() {
		return (int)result;
	}
}
