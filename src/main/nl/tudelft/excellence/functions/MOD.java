package nl.tudelft.excellence.functions;

/**
 * Returns a mod b
 * <b>Syntax:</b> MOD(double a, double b)
 */

public class MOD extends NumberFunction{
	
	private double value1, value2;
	
	public MOD(double a, double b){
		value1 = a;
		value2 = b;
	}

	@Override
	public double execute() {
		return value1 % value2;
	}

}
