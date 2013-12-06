package nl.tudelft.excellence.functions;

/**
 * This function counts how many cells in a given range are not empty.
 * <b>Syntax:</b> COUNTA(String a[, String b, String c...])
 */

public class COUNTA extends NumberFunction{
	
	private String[] cells;
	
	public COUNTA(String a, String...strings ){
		cells = new String[strings.length + 1];
		cells[0] = a;
		for(int i = 0; i < strings.length; i++){
			cells[i+1] = strings[i];
		}
	}

	@Override
	public double execute() {
		double result = 0;
		for(int i = 0; i < cells.length; i++){
			if(cells[i] != null){
				result++;
			}
		}
		return result;
	}

}
