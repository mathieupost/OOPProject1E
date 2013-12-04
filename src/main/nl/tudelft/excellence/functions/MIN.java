package nl.tudelft.excellence.functions;

/**
 * Returns the minimum of all inserted values
 * <b>Syntax:</b> MIN(double a, double... values)
 */
public class MIN extends StringFunction {
	
	private double[] input;
	
	public MIN(double a, double... values){
		input = new double[values.length+1];
		input[0] = a;
		for(int i = 0; i<values.length;i++){
			input[i+1] = values[i];
		}
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return null;
	}
}
