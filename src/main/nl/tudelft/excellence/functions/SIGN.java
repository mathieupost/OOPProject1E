package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns 1.0 when double x > 0, 0.0 when x = 0 and -1.0 when x < 0
 * <b>Syntax:</b> SIGN(double x)
 */

public class SIGN extends NumberFunction{
	
	private double sign;
	
	final static int MIN_ARGS = 1;
	final static int MAX_ARGS = 1;
	
	public SIGN(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, MAX_ARGS, values);
		try{
			sign = Double.parseDouble(values[0]);
		}
		catch(NumberFormatException e){
            throw new IllegalFunctionArgumentsException("Expected a number, but got: '" + (values[0].startsWith(" ") ? values[0].substring(1) : values[0]) + "'");
        }
    }

    @Override
	public double execute() {
		return Integer.signum(Double.compare(sign, 0));
	}

}
