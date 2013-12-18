package nl.tudelft.excellence.functions;

/**
 * Converts a String into all lowercase letters
 * <b>Syntax:</b> LOWER(String value)
 */
public class LOWER extends StringFunction{
	
	private String lower;
	
	public LOWER(String value){
		lower = value;
	}

	@Override
	public String execute() {
		return lower.toLowerCase();
	}
}
