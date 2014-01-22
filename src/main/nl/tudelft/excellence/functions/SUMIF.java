package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Checks for given doubles if they meet a certain criteria (e.g. < 60)
 * If yes, adds them to a total if they also fall in a given sum range (optional)
 *
 */
public class SUMIF extends NumberFunction {
	final static int MIN_ARGS = 3;
	
	private double[] range;
	private double criteria;
	private String operand;
	private double res;
	
	/**
	 * Constructor for case with a sum range
	 * @param criteria1 number which in combination with operand will be used to compare input
	 * @param criteria_operand operand which in combination with criteria1 will be used to compare input
	 * @param input_range array of doubles which are to be checked
	 * @param sum_range_low bottom edge of sum range
	 * @param sum_range_high top edge of sum range
	 */
	public SUMIF(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		
		try{
			criteria = Double.parseDouble(values[0]);
			operand = values[1];
			range = new double[values.length];
			
			for(int i = 2; i < values.length; i++){
				range[i] = Double.parseDouble(values[i]);
			}
			
			
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
	}
	
	

	/**
	 * Performs the calculation
	 */
	public double execute() {
		if (operand.equals("=")) {
			for (int i = 2; i < range.length; i++) {
				if (range[i] == criteria) {
					res += range[i];
				}
			}
		} else if (operand.equals("!=")) {
			for (int i = 2; i < range.length; i++) {
				if (range[i] != criteria) {
					res += range[i];
				}
			}
		} else if (operand.equals("<")) {
			for (int i = 2; i < range.length; i++) {
				if (range[i] < criteria) {
					res += range[i];
				}
			}
		} else if (operand.equals(">")) {
			for (int i = 2; i < range.length; i++) {
				if (range[i] > criteria) {
					res += range[i];
				}
			}
		} else if (operand.equals("<=")) {
			for (int i = 2; i < range.length; i++) {
				if (range[i] <= criteria) {
					res += range[i];
				}
			}
		} else if (operand.equals(">=")) {
			for (int i = 2; i < range.length; i++) {
				if (range[i] >= criteria) {
					res += range[i];
				}
			}
		}
		return res;
	}
}
