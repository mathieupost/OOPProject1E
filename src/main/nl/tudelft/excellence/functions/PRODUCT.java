package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Multiplies all numbers given as arguments
 * <b>Syntax:</b> PRODUCT(double a, double b, double... values)
 */
public class PRODUCT extends NumberFunction {
	final static int MIN_ARGS = 2;
	
	private double[] input;
	
	public PRODUCT(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		
		input = new double[values.length];
	
		for(int i = 0; i<values.length;i++){
			try{
				input[i] = Double.parseDouble(values[i]);
			}catch(NumberFormatException e){
				throw new IllegalFunctionArgumentsException(e);
			}
		}
	}

	@Override
	public double execute() {
		double product = 1;
		for (int i = 0; i < input.length; i++){
			product *= input[i];
		}
		return product;
	}
}
