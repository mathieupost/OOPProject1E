package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Count how many cells in a given range meet a given logical condition
 * <b>Syntax:</b> COUNTIF(double criteria, String criteria_operand, double...cells
 */
public class COUNTIF extends NumberFunction{
	final static int MIN_ARGS = 2;
	
	private double[] cells;
	private double criteria;
	private String operand;
	
	
	public COUNTIF(String... values){
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
			throw new IllegalFunctionArgumentsException("Expected a number, but got: '"+values[cur]+"'");
		}
		operand = values[1];
		if(!operand.matches("((!?=)|((<|>)=?))"))
			throw new IllegalFunctionArgumentsException("Invalid operand supplied: " + operand);
	}

	@Override
	public double execute() {
		double res = 0;
		if (operand.equals("=")) {
			for (double cell : cells) {
				if (cell == criteria) {
					res++;
				}
			}
		} else if (operand.equals("!=")) {
			for (double cell : cells) {
				if (cell != criteria) {
					res++;
				}
			}
		} else if (operand.equals("<")) {
			for (double cell : cells) {
				if (cell < criteria) {
					res++;
				}
			}
		} else if (operand.equals(">")) {
			for (double cell : cells) {
				if (cell > criteria) {
					res++;
				}
			}
		} else if (operand.equals("<=")) {
			for (double cell : cells) {
				if (cell <= criteria) {
					res++;
				}
			}
		} else if (operand.equals(">=")) {
			for (double cell : cells) {
				if (cell >= criteria) {
					res++;
				}
			}
		}
		
		return res;
	}
}
	
