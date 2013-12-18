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
		IF i = new IF(value, "ja", "nee");
		if(i.execute().equals("ja") || i.execute().equals("nee")){
			return true;
		}
		return false;
	}
}
