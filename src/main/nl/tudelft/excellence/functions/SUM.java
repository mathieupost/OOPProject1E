package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns the sum of double a and double b
 * <b>Syntax:</b> SUM(double a, double b, double... values)
 */
public class SUM extends NumberFunction {
	final static int MIN_ARGS = 2;
	
	private double[] input;
	
	public SUM(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		
		input = new double[values.length];
		
		for(int i = 0; i<values.length; i++){
			try{
				input[i] = Double.parseDouble(values[i]);
			} catch(NumberFormatException e){
				throw new IllegalFunctionArgumentsException(e);
			}
		}
	}

	@Override
	public double execute() {
		double sum = 0;
        for (double value : input) {
            sum += value;
        }
		return sum;
	}
}
