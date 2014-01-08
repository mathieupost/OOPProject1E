package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * The COUNT function returns the amount of cells in a range that contains numbers.
 * <b>Syntax:</b> COUNT(String a[, String b, String c...])
 */
public class COUNT extends NumberFunction {
	final static int MIN_ARGS = 1;
	
	private String[] input;
	
	public COUNT(String... strings) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, strings);
		input = new String[strings.length];
		for (int i = 0; i < strings.length; i++) {
			input[i] = strings[i];
		}
	}

	@Override
	public double execute() {
		double res = 0;
		for(int i=0; i<input.length; i++){
			try{
				Double.parseDouble(input[i]);
				res++;
			}
			catch(Exception e){
			}
		}
		return res;
	}
}
