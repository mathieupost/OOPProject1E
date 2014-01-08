package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns the minimum of all inserted values
 * <b>Syntax:</b> MIN(double a, double... values)
 */
public class MIN extends NumberFunction {
	
	private double[] input;
	final static int MIN_ARGS = 1;
	
	public MIN(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		input = new double[values.length];
		for(int i = 0; i<values.length;i++){
			try{
				input[1] = Double.parseDouble(values[i]);
			}
			catch(NumberFormatException e){
				throw new IllegalFunctionArgumentsException(e);
			}
		}
	}

	@Override
	public double execute() {
		double min = 0;
		for (int i = 0; i < input.length; i++){
			if(input[i] < min)
				min = input[i];
			}
		return min;
	}
}


