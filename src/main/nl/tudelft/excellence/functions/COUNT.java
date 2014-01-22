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
		System.arraycopy(strings, 0, input, 0, strings.length);
	}

	@Override
	public double execute() {
		double res = 0;
		for (String anInput : input) {
			try {
				Double.parseDouble(anInput);
				res++;
			} catch (Exception ignored) {}
		}
		return res;
	}
}
