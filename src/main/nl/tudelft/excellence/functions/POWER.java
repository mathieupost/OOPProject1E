package nl.tudelft.excellence.functions;

/**
 * Returns base raised to the power exp
 * 
 * @param base
 *            base
 * @param exp
 *            exponent
 * @return result
 */
public class POWER extends NumberFunction {

private double base;
private double exp;
	
	public POWER(double a, double b) {
		base = a;
		exp = b;
	}

	public double execute() {
		return Math.pow(base, exp);
	}
}
