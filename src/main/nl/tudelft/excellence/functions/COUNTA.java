package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * This function counts how many cells in a given range are not empty.
 * <b>Syntax:</b> COUNTA(String a[, String b, String c...])
 */

public class COUNTA extends NumberFunction{
	final static int MIN_ARGS = 1;
	
	private String[] cells;
	
	public COUNTA(String...strings) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, strings);
		cells = strings;
	}

	@Override
	public double execute() {
		double result = 0;
		for (String cell : cells) {
			if (cell != null && cell.length() != 0) {
				result++;
			}
		}
		return result;
	}

}
