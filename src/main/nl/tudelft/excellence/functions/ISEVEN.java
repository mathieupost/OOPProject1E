package nl.tudelft.excellence.functions;

/**
 * Checks if a given double is an even number
 * <b>Syntax:</b> ISEVEN(double value) 
 */
public class ISEVEN extends BooleanFunction {
	
	private double result;
	
	public ISEVEN(double value){
		result = value;
	}

	@Override
	public boolean execute() {
		return (int)result % 2 == 0? true : false;
	}
}
