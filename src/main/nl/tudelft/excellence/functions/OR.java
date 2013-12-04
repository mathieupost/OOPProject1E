package nl.tudelft.excellence.functions;

/**
 * Returns true, when 1 or more input values is true, and returns false when all input is false
 * <b>Syntax:</b> OR(boolean a[, boolean b, boolean c...])
 */

public class OR extends BooleanFunction{
	
	private boolean[] values;
	
	public OR(boolean a, boolean...bs){
		values = new boolean[bs.length + 1];
		values[0] = a;
		for(int i = 0; i < bs.length; i++){
			values[i+1] = bs[i];
		}
	}

	@Override
	public boolean execute() {
		boolean result = false;
		for(int i = 0; i < values.length; i++){
			if(values[i] == true){
				result = true;
			}
		}
		return result;
	}

}
