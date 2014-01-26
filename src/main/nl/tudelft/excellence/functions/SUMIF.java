package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Checks for given doubles if they meet a certain criteria (e.g. < 60)
 * If yes, adds them to the total
 *
 */
public class SUMIF extends NumberFunction {
	private double[] cells;
	private double criteria;
	private String operand;
	private double res;

	final static int MIN_ARGS = 3;

	/**
	 * param criteria1 number which in combination with operand will be used to compare input<br>
	 * param criteria_operand operand which in combination with criteria1 will be used to compare input<br>
	 * param input_range array of doubles which are to be checked
	 */
	public SUMIF(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, values);
		cells = new double[values.length-2];

		int cur = 2;
		try{
			for(int i = 2; i < values.length; i++){
				cur = i;
				cells[i-2] = Double.parseDouble(values[i]);
			}
			cur = 0;
			criteria = Double.parseDouble(values[0]);
		}catch(NumberFormatException e){
            throw new IllegalFunctionArgumentsException("Expected a number, but got: '" + (values[cur].startsWith(" ") ? values[cur].substring(1) : values[cur]) + "'");
        }
        operand = values[1];
        if(!operand.matches("((!?=)|((<|>)=?))"))
			throw new IllegalFunctionArgumentsException("Invalid operand supplied: " + operand);
	}

	

	/**
	 * Performs the calculation
	 */
	public double execute() {
		if (operand.equals("=")) {
			for (double cell : cells) {
				if (cell == criteria) {
					res += cell;
				}
			}
		} else if (operand.equals("!=")) {
			for (double cell : cells) {
				if (cell != criteria) {
					res += cell;
				}
			}
		} else if (operand.equals("<")) {
			for (double cell : cells) {
				if (cell < criteria) {
					res += cell;
				}
			}
		} else if (operand.equals(">")) {
			for (double cell : cells) {
				if (cell > criteria) {
					res += cell;
				}
			}
		} else if (operand.equals("<=")) {
			for (double cell : cells) {
				if (cell <= criteria) {
					res += cell;
				}
			}
		} else if (operand.equals(">=")) {
			for (double cell : cells) {
				if (cell >= criteria) {
					res += cell;
				}
			}
		}
		return res;
	}
}
