package nl.tudelft.excellence.functions;

/**
 * Returns the sum of double a and double b
 * <b>Syntax:</b> SUM(double a, double b, double... values)
 */
public class SUM extends NumberFunction {
	
	private double[] input;
	
	public SUM(double a, double b, double... values){
		input = new double[values.length+2];
		input[0] = a;
		input[1] = b;
		for(int i = 0; i<values.length;i++){
			input[i+2] = values[i];
		}
	}

	@Override
	public double execute() {
		double sum = 0;
		for (int i = 0; i < input.length; i++){
			sum += input[i];
		}
		return sum;
	}
}
