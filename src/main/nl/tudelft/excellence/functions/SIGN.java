package nl.tudelft.excellence.functions;

/**
 * Returns 1.0 when double x > 0, 0.0 when x = 0 and -1.0 when x < 0
 * <b>Syntax:</b> SIGN(double x)
 */

public class SIGN extends NumberFunction{
	
	private double sign;
	
	public SIGN(double x){
		sign = x;
	}

	@Override
	public double execute() {
		return Double.compare(sign, 0);
	}

}
