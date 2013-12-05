package nl.tudelft.excellence.functions;

/**
 * The COUNT function returns the amount of cells in a range that contains numbers.
 * <b>Syntax:</b> COUNT(String a[, String b, String c...])
 */
public class COUNT extends NumberFunction {
	private String[] input;
	
	public COUNT(String a, String...strings ){
		input = new String[strings.length + 1];
		input[0] = a;
		for (int i = 0; i < strings.length; i++) {
			input[i + 1] = strings[i];
		}
	}

	@Override
	public double execute() {
		double res = 0;
		for(int i=0;i<input.length;i++){
			if(input[i].matches(".*\\d.*")){
				res++;
			}
		}
		return res;
	}
}
