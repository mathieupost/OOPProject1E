package nl.tudelft.excellence.functions;

/**
 * Return the NOT value
 * <b>Syntax:</b> NOT(boolean value)
 */
public class NOT extends BooleanFunction {
	
	boolean input;
	
	public NOT(boolean value){
		input = value;
	}


	@Override
	public boolean execute() {
		return !input;
	}
}