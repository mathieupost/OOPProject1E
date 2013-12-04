package nl.tudelft.excellence.functions;

/**
 * Rounds up double x away from zero, at digits amount of digits
 * <b>Syntax:</b> ROUNDUP(double x, double digits)
 */
public class ROUNDUP extends NumberFunction {
	
	private double a,b;
	
	public ROUNDUP(double x, double digits){
		a = x;
		b = digits;
	}

	@Override
	public double execute() {
		a *= Math.pow(10, b);
		a++;
		a = (int)a;
		a /= Math.pow(10, b);
		return a;
	}
}
