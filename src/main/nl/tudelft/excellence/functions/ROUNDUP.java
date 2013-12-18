package nl.tudelft.excellence.functions;

import java.math.BigDecimal;

/**
 * Rounds up double x away from zero, at digits amount of digits
 * <b>Syntax:</b> ROUNDUP(String x, int digits)
 */
public class ROUNDUP extends NumberFunction {
	
	private BigDecimal a;
	private int b;
	
	public ROUNDUP(String x, int digits){
		a = new BigDecimal(x);
		b = digits;
	}

	@Override
	public double execute() {
		
		a = a.setScale(b, BigDecimal.ROUND_UP);
		
		return a.doubleValue();
		
	
	}
}
