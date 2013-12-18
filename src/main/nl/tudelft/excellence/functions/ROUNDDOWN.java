package nl.tudelft.excellence.functions;

import java.math.BigDecimal;

/**
 * Rounds down x to zero, at digits amount of digits
 *<b>Syntax:</b> ROUNDDOWN(String x, int digits)
 */
public class ROUNDDOWN extends NumberFunction {

	private BigDecimal a;
	private int  b;

	public ROUNDDOWN(String x, int digits) {
		a = new BigDecimal(x);
		b = digits;
	}

	@Override
	public double execute() {
		
		a = a.setScale(b);
	
		return a.doubleValue();
	}

}
