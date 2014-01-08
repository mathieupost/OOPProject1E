package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns the square root of double x
 * 
 * @param x
 *            variable
 * @return square root
 */
public class SQRT extends NumberFunction {
	final static int MIN_ARGS = 1;
	
	private double input;

	public SQRT(String in) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, in);
		
		try{
			input = Double.parseDouble(in);
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	}

	@Override
	public double execute() {
		return Math.sqrt(input);
	}

}
