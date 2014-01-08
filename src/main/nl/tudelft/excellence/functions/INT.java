package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Rounds a double down and converts that to an integer
 * <b>Syntax:</b> INT(double value)
 */

public class INT extends NumberFunction {
	final static int MIN_ARGS = 1;
	
	private double result;
	
	public INT(String value){
		super(MIN_ARGS, value);
		
		try{
		result = Double.parseDouble(value);
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	}

	@Override
	public double execute() {
		return (int)result;
	}
}
