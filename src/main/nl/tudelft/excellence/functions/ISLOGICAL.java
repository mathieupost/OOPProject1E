package nl.tudelft.excellence.functions;

/**
 * Checks if a given String is a representation of a logical value
 * <b>Syntax:</b> ISLOGICAL(String value) 
 */
public class ISLOGICAL extends BooleanFunction{
	private String value;
	
	public ISLOGICAL(String input){
		value = input;
	}

	@Override
	public boolean execute() {
		return value.toLowerCase().equals("true")|| value.toLowerCase().equals("false");
	}
}
