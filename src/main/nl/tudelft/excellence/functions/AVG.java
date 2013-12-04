package nl.tudelft.excellence.functions;

/**
 * The AVG function calculates the average of a set of numeric values.
 * <b>Syntax:</b> AVG(double a[, double b, double c...]) 
 */
public class AVG extends NumberFunction{
	private double[] input;
	
	public AVG(double a, double... values){
		input = new double[values.length+1];
		input[0] = a;
		for(int i = 0; i<values.length;i++){
			input[i+1] = values[i];
		}
	}

	@Override
	public double execute() {
		double avg = 0;
		for (int i = 0; i < input.length; i++) {
			avg += input[i];
		}
		return avg / input.length;
	}
}
