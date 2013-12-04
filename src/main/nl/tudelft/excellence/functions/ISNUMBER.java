package nl.tudelft.excellence.functions;

/**
 * This function checks if a given String is a number
 * <b>Sytax:</b> ISNUMBER(String value)
 */

public class ISNUMBER extends BooleanFunction{
	
	private String input;
	
	public ISNUMBER(String value){
		input = value;
	}

	@Override
	public boolean execute() {
		try {
			Double.parseDouble(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
