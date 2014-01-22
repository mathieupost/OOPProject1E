package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns true, when 1 or more input values is true, and returns false when all input is false
 * <b>Syntax:</b> OR(boolean a[, boolean b, boolean c...])
 */

public class OR extends BooleanFunction{
	final static int MIN_ARGS = 1;
	
	private boolean[] input;
	
	public OR(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		
		input = new boolean[values.length];
		
		for(int i = 0; i < values.length; i++){
			try{
				input[i] = Boolean.parseBoolean(values[i]);
			}catch(NumberFormatException e){
				throw new IllegalFunctionArgumentsException(e);
			}
		}
	}

	@Override
	public boolean execute() {
		boolean result = false;
		for (boolean anInput : input) {
			if (anInput) {
				result = true;
			}
		}
		return result;
	}

}
