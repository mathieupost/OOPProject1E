package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Calculates the maximum value of a given number of doubles<br>
 * 
 * param a<br>
 *            the first double<br>
 * param values<br>
 *            the rest of the doubles<br>
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
				throw new IllegalFunctionArgumentsException("Expected a number, but got: "+values[i]);
			}
		}
	}

	@Override
	public double execute() {
		double res = 0;
		for (double anInput : input) {
			if (anInput > res) {
				res = anInput;
			}
		}
		return res;
	}

}
