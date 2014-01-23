package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns the square root of double x<br>
 * 
 * param x<br>
 * @return square root
 */
public class SQRT extends NumberFunction {
	private double input;

	final static int MIN_ARGS = 1;
	final static int MAX_ARGS = 1;

	public SQRT(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		
		try{
			input = Double.parseDouble(values[0]);
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException("Expected a number, but got: '"+values[0]+"'");
		}
	}

	@Override
	public double execute() {
		return Math.sqrt(input);
	}

}
