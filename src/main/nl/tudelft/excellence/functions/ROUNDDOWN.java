package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

import java.math.BigDecimal;

/**
 * Rounds down x to zero, at digits amount of digits
 *<b>Syntax:</b> ROUNDDOWN(double x, double digits)
 */
public class ROUNDDOWN extends NumberFunction {

	private BigDecimal a;
	private int  b;
	
	final static int MIN_ARGS = 2;

	public ROUNDDOWN(String... values) throws IllegalFunctionArgumentsException {
		super(MIN_ARGS, values);
		try{
		a = new BigDecimal(values[0]);
		b = Integer.parseInt(values[1]);
		}
		catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	}

	@Override
	public double execute() {
		
		a = a.setScale(b, BigDecimal.ROUND_DOWN);
	
		return a.doubleValue();
	}

}
