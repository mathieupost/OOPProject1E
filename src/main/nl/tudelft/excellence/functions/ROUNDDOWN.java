package nl.tudelft.excellence.functions;

/**
 * Rounds down x to zero, at digits amount of digits
 * 
 * @param x
 *            number
 * @param digits
 *            amount of digits
 * @return rounddown x
 */
public class ROUNDDOWN extends NumberFunction {

	private double a, b;

	public ROUNDDOWN(double x, double digits) {
		a = x;
		b = digits;
	}

	@Override
	public double execute() {
		a *= Math.pow(10, b);
		a = (int) a;
		a /= Math.pow(10, b);
		return a;
	}

}
