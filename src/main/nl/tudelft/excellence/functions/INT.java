package nl.tudelft.excellence.functions;

/**
 * Rounds a double down and converts that to an integer
 * <b>Syntax:</b> INT(double value)
 */

public class INT extends NumberFunction {
	
	private double result;
	
	public INT(double value){
		result = value;
	}

	@Override
	public double execute() {
		return (int)result;
	}
}
