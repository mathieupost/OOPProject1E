package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * This function counts how many cells in a given range are not empty.
 * <b>Syntax:</b> COUNTA(String a[, String b, String c...])
 */

public class COUNTA extends NumberFunction{
	final static int MIN_ARGS = 1;
	
	private String[] cells;
	
	public COUNTA(String...strings ) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, strings);
		
		cells = new String[strings.length];
		
		for(int i = 0; i < strings.length; i++){

			cells[i] = strings[i];
		}
	}

	@Override
	public double execute() {
		double result = 0;
		for(int i = 0; i < cells.length; i++){
			if(cells[i] != null && cells[i].length() != 0){
				result++;
			}
		}
		return result;
	}

}
