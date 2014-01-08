package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

import java.math.BigDecimal;

/**
 * Rounds up double x away from zero, at digits amount of digits
 * <b>Syntax:</b> ROUNDUP(double x, double digits)
 */
public class ROUNDUP extends NumberFunction {
	final static int MIN_ARGS = 2;
	
	private BigDecimal a;
	private int b;
	
	public ROUNDUP(String... digits) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, digits);
		
		try{
			a = new BigDecimal(digits[0]);
			b = Integer.parseInt(digits[1]);
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	}

	@Override
	public double execute() {
		
		a = a.setScale(b, BigDecimal.ROUND_UP);
		
		return a.doubleValue();
		
	
	}
}
