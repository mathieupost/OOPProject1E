package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

import java.util.Arrays;

/**
 * Takes a series of doubles and calculates the arithmetic median.
 * <b>Syntax:</b> MEDIAN(double a[, double b, double c...])
 */

public class MEDIAN extends NumberFunction{
	
	private double[] input;
	
	final static int MIN_ARGS = 1;
	
	public MEDIAN(String...values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		input = new double[values.length];
		for(int i = 0; i<values.length;i++){
			try{
				input[i] = Double.parseDouble(values[i]);
			}
			catch(NumberFormatException e){
				throw new IllegalFunctionArgumentsException("Expected a number, but got: "+values[i]);
			}
		}
	}

	@Override
	public double execute() {
		Arrays.sort(input);
		double res = 0;
		if(input.length %2==0){
			int a = input.length/2-1;
			int b = input.length/2;
			res = (input[a]+input[b])/2;
		}
		else if(input.length %2 != 0){
			int a = (input.length-1)/2;
			res = input[a];
		}
		return res;
	}

}
