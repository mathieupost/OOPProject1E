package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns a mod b
 * <b>Syntax:</b> MOD(double a, double b)
 */

public class MOD extends NumberFunction{
	final static int MIN_ARGS = 2;
	
	private double value1, value2;
	
	public MOD(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		
		try{
			value1 = Double.parseDouble(values[0]);
			value2 = Double.parseDouble(values[1]);
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	}

	@Override
	public double execute() {
		return value1 % value2;
	}

}
