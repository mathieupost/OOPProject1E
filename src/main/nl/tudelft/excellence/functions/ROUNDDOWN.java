package nl.tudelft.excellence.functions;

import java.math.BigDecimal;

/**
 * Rounds down x to zero, at digits amount of digits
 *<b>Syntax:</b> ROUNDDOWN(double x, double digits)
 */
public class ROUNDDOWN extends NumberFunction {

	private BigDecimal a;
	private int  b;

	public ROUNDDOWN(double x, double digits) {
		String c = x + "";
		a = new BigDecimal(c);
		b = (int) digits;
	}

	@Override
	public double execute() {
		
		a = a.setScale(b, BigDecimal.ROUND_DOWN);
	
		return a.doubleValue();
	}

}
