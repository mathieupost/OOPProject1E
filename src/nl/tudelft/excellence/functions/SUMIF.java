package nl.tudelft.excellence.functions;

public class SUMIF extends NumberFunction {
	private String[] range; // values to apply criteria on
	private double[] sum_range; // values to sum
	private String criteria; // criteria

	public SUMIF(String criteria, String[] input_range, double a,
			double... input_sum_range) {
		sum_range = new double[input_sum_range.length + 1];
		sum_range[0] = a;
		for (int i = 0; i < input_sum_range.length; i++) {
			sum_range[i + 1] = input_sum_range[i];
		}
	}

	public double execute() {
		return 0;
	}
}
