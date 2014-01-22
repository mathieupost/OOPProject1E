package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Checks if a given double is an even number
 * <b>Syntax:</b> ISEVEN(double value) 
 */
public class ISEVEN extends BooleanFunction {
	final static int MIN_ARGS = 1;
	
	private double result;
	
	public ISEVEN(String value) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, value);
		
		try{
			result = Double.parseDouble(value);
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	
		}

	@Override
	public boolean execute() {
		return ((int) result) % 2 == 0;
	}
}
