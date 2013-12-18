package nl.tudelft.excellence.functions;

import java.math.BigDecimal;

/**
 * Rounds up double x away from zero, at digits amount of digits
 * <b>Syntax:</b> ROUNDUP(double x, double digits)
 */
public class ROUNDUP extends NumberFunction {
	
	private BigDecimal a;
	private int b;
	
	public ROUNDUP(double x, double digits){
		String c = x + "";
		a = new BigDecimal(c);
		b = (int) digits;
	}

	@Override
	public double execute() {
		
		a = a.setScale(b, BigDecimal.ROUND_UP);
		
		return a.doubleValue();
		
	
	}
}
