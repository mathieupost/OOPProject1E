package nl.tudelft.excellence.functions;

public class SUMIF extends NumberFunction {
	private double[] range; // values to apply criteria on
	// private double[] sum_range; // values to sum
	private double criteria; // criteria 1
	private String operand; // =, !=, >, <, =>, <=
	private double sumrangelow;
	private double sumrangehigh;
	private double res;

	public SUMIF(double criteria1, String criteria_operand,
			double[] input_range, double sum_range_low, double sum_range_high) {
		range = input_range;
		criteria = criteria1;
		operand = criteria_operand;
		sumrangelow = sum_range_low;
		sumrangehigh = sum_range_high;
	}

	public SUMIF(double criteria1, String criteria_operand, double[] input_range) {
		range = input_range;
		criteria = criteria1;
		operand = criteria_operand;
		sumrangelow = Double.NEGATIVE_INFINITY;
		sumrangehigh = Double.POSITIVE_INFINITY;
	}

	public double execute() {
		if (operand.equals("=")) {
			for (int i = 0; i < range.length; i++) {
				if (range[i] == criteria && range[i] >= sumrangelow
						&& range[i] <= sumrangehigh) {
					res += range[i];
				}
			}
		} else if (operand.equals("!=")) {
			for (int i = 0; i < range.length; i++) {
				if (range[i] != criteria && range[i] >= sumrangelow
						&& range[i] <= sumrangehigh) {
					res += range[i];
				}
			}
		} else if (operand.equals("<")) {
			for (int i = 0; i < range.length; i++) {
				if (range[i] < criteria && range[i] >= sumrangelow
						&& range[i] <= sumrangehigh) {
					res += range[i];
				}
			}
		} else if (operand.equals(">")) {
			for (int i = 0; i < range.length; i++) {
				if (range[i] > criteria && range[i] >= sumrangelow
						&& range[i] <= sumrangehigh) {
					res += range[i];
				}
			}
		} else if (operand.equals("<=")) {
			for (int i = 0; i < range.length; i++) {
				if (range[i] <= criteria && range[i] >= sumrangelow
						&& range[i] <= sumrangehigh) {
					res += range[i];
				}
			}
		} else if (operand.equals(">=")) {
			for (int i = 0; i < range.length; i++) {
				if (range[i] >= criteria && range[i] >= sumrangelow
						&& range[i] <= sumrangehigh) {
					res += range[i];
				}
			}
		}
		return res;
	}
}
