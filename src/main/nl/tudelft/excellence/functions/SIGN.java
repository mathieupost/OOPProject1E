package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns 1.0 when double x > 0, 0.0 when x = 0 and -1.0 when x < 0
 * <b>Syntax:</b> SIGN(double x)
 */

public class SIGN extends NumberFunction{
	
	private double sign;
	
	final static int MIN_ARGS = 1;
	
	public SIGN(String x) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, x);
		try{
			sign = Double.parseDouble(x);
		}
		catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	}

	@Override
	public double execute() {
		return Double.compare(sign, 0);
	}

}
