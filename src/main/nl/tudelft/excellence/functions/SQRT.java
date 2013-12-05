package nl.tudelft.excellence.functions;

/**
 * Returns the square root of double x
 * 
 * @param x
 *            variable
 * @return square root
 */
public class SQRT extends NumberFunction {
	private double input;

	public SQRT(double in) {
		input = in;
	}

	@Override
	public double execute() {
		return Math.sqrt(input);
	}

}
