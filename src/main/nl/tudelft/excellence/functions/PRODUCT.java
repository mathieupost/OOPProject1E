package nl.tudelft.excellence.functions;

/**
 * Multiplies all numbers given as arguments
 * <b>Syntax:</b> PRODUCT(double a, double b, double... values)
 */
public class PRODUCT extends NumberFunction {
	
	private double[] input;
	
	public PRODUCT(double a, double b, double... values){
		input = new double[values.length+2];
		input[0] = a;
		input[1] = b;
		for(int i = 0; i<values.length;i++){
			input[i+2] = values[i];
		}
	}

	@Override
	public double execute() {
		double product = 0;
		for (int i = 0; i < input.length; i++){
			product *= input[i];
		}
		return product;
	}
}
