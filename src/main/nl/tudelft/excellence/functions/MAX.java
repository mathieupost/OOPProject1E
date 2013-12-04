package nl.tudelft.excellence.functions;

/**
 * Calculates the maximum value of a given number of doubles
 * 
 * @param a
 *            the first double
 * @param values
 *            the rest of the doubles
 * @return maximum of given doubles
 */
public class MAX extends NumberFunction {
	private double[] input;

	public MAX(double a, double... values) {
		input = new double[values.length + 1];
		input[0] = a;
		for (int i = 0; i < values.length; i++) {
			input[i + 1] = values[i];
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
