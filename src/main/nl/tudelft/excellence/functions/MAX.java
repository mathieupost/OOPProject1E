package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Calculates the maximum value of a given number of doubles
 * 
 * @param a
 *            the first double
 * @param values
 *            the rest of the doubles
 * @return maximum of given doubles
 */
public class MAX extends NumberFunction{
	final static int MIN_ARGS = 1;
	
	private double[] input;

	public MAX(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		input = new double[values.length];
		
		for (int i = 0; i < values.length; i++) {
			try{
				input[i] = Double.parseDouble(values[i]);
			}catch(NumberFormatException e){
				throw new IllegalFunctionArgumentsException(e);
			}
		}
	}

	@Override
	public double execute() {
		double res = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > res) {
				res = input[i];
			}
		}
		return res;
	}

}
