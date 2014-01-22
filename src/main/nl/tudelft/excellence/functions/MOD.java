package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns a mod b
 * <b>Syntax:</b> MOD(double a, double b)
 */

public class MOD extends NumberFunction{
	final static int MIN_ARGS = 2;
	final static int MAX_ARGS = 2;
	
	private double value1, value2;
	
	public MOD(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, MAX_ARGS, values);

		int cur = 0;
		try{
			value1 = Double.parseDouble(values[0]);
			cur++;
			value2 = Double.parseDouble(values[1]);
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException("Expected a number, but got: "+values[cur]);
		}
	}

	@Override
	public double execute() {
		return value1 % value2;
	}

}
