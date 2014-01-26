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
	final static int MAX_ARGS = 2;

	public ROUNDDOWN(String... values) throws IllegalFunctionArgumentsException {
		super(MIN_ARGS, MAX_ARGS, values);
		int cur = 0;
		try{
			a = new BigDecimal(values[0]);
			cur++;
			b = Integer.parseInt(values[1]);
		} catch(NumberFormatException e){
            throw new IllegalFunctionArgumentsException("Expected a number, but got: '" + (values[cur].startsWith(" ") ? values[cur].substring(1) : values[cur]) + "'");
        }
    }

    @Override
	public double execute() {
		return a.setScale(b, BigDecimal.ROUND_DOWN).doubleValue();
	}

}
