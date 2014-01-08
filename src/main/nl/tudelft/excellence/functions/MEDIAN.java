package nl.tudelft.excellence.functions;

import java.util.Arrays;

/**
 * Takes a series of doubles and calculates the arithmetic median.
 * <b>Syntax:</b> MEDIAN(double a[, double b, double c...])
 */

public class MEDIAN extends NumberFunction{
	
	private double[] input;
	
	public MEDIAN(double a, double...ds ){
		input = new double[ds.length+1];
		input[0] = a;
		for(int i = 0; i<ds.length;i++){
			input[i+1] = ds[i];
		}
	}

	@Override
	public double execute() {
		Arrays.sort(input);
		double res = 0;
		if(input.length %2==0){
			int a = (int) input.length/2-1;
			int b = (int) input.length/2;
			res = (input[a]+input[b])/2;
		}
		else if(input.length %2 != 0){
			int a = (input.length-1)/2;
			res = input[a];
		}
		return res;
	}

}
