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
        System.arraycopy(values, 0, input, 2, values.length);
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
