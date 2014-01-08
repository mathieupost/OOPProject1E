package nl.tudelft.excellence.functions;

/**
 * Checks for given doubles if they meet a certain criteria (e.g. < 60)
 * If yes, adds them to a total if they also fall in a given sum range (optional)
 * @author Casper
 *
 */
public class SUMIF extends NumberFunction {
	private double[] range;
	private double criteria;
	private String operand;
	private double sumrangelow;
	private double sumrangehigh;
	private double res;
	
	/**
	 * Constructor for case with a sum range
	 * @param criteria1 number which in combination with operand will be used to compare input
	 * @param criteria_operand operand which in combination with criteria1 will be used to compare input
	 * @param input_range array of doubles which are to be checked
	 * @param sum_range_low bottom edge of sum range
	 * @param sum_range_high top edge of sum range
	 */
	public SUMIF(double criteria1, String criteria_operand,
			double[] input_range, double sum_range_low, double sum_range_high) {
		range = input_range;
		criteria = criteria1;
		operand = criteria_operand;
		sumrangelow = sum_range_low;
		sumrangehigh = sum_range_high;
	}
	
	/**
	 * Constructor for case without a sum range
	 * @param criteria1 number which in combination with operand will be used to compare input
	 * @param criteria_operand operand which in combination with criteria1 will be used to compare input
	 * @param input_range array of doubles which are to be checked
	 */
	public SUMIF(double criteria1, String criteria_operand, double[] input_range) {
		range = input_range;
		criteria = criteria1;
		operand = criteria_operand;
		sumrangelow = Double.NEGATIVE_INFINITY;
		sumrangehigh = Double.POSITIVE_INFINITY;
	}

	/**
	 * Performs the calculation
	 */
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
