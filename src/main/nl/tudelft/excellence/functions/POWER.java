package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns base raised to the power exp
 * 
 * @param base
 *            base
 * @param exp
 *            exponent
 * @return result
 */
public class POWER extends NumberFunction {

private double base;
private double exp;

final static int MIN_ARGS = 2;
	
	public POWER(String...strings) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, strings);
		try{
			base = Double.parseDouble(strings[0]);
			exp = Double.parseDouble(strings[1]);
		}
		catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	}

	public double execute() {
		return Math.pow(base, exp);
	}
}
