package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;
import nl.tudelft.excellence.utilities.Utility;

/**
 * Converts a String into a logical condition and tests that condition<br>
 * Returns a given String if the test returns true, returns another given String if the test returns false<br>
 * param iftrue String which is to be returned if the logical condition returns true<br>
 * param iffalse String which is to be returned if the logical condition returns false<br>
 */
public class IF extends StringFunction {
	private String logictest;
	private String iftrue;
	private String iffalse;

	final static int MIN_ARGS = 1;
	final static int MAX_ARGS = 3;

	public IF(String... values) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, MAX_ARGS, values);

		if (values.length == 2) {
			throw new IllegalFunctionArgumentsException("This function expects either 1 or 3 arguments");
		}

		logictest = Utility.getValue(values[0].trim());

		this.logictest = logictest.replaceFirst("((!?=)|((<|>)=?))", "|$0|");

		if (values.length == 3) {
			iftrue = values[1];
			iffalse = values[2];
		} else {
			iftrue = "true";
			iffalse = "false";
		}

		if(!Utility.isBoolean(logictest)){
			String[] split = logictest.split("\\|");
			int cur = 0;
			try{
				Double.parseDouble(Utility.getValue(split[0]));
				cur = 2;
				Double.parseDouble(Utility.getValue(split[2]));
			} catch(NumberFormatException e){
				throw new IllegalFunctionArgumentsException("Expected a number, but got: "+split[cur]);
			}
		}
	}

	@Override
	public String execute() {
		if(Utility.isBoolean(logictest)){
			return (Boolean.parseBoolean(logictest))?iftrue:iffalse;
		}
		
		String[] split = logictest.split("\\|");
		double a = Double.parseDouble(Utility.getValue(split[0]));
		double b = Double.parseDouble(Utility.getValue(split[2]));
		
		if (split[1].equals("=")) {
			if (a == b) {
				return iftrue;
			} else {
				return iffalse;
			}
		} else if (split[1].equals("!=")) {
			if (a != b) {
				return iftrue;
			} else {
				return iffalse;
			}
		} else if (split[1].equals("<")) {
			if (a < b) {
				return iftrue;
			} else {
				return iffalse;
			}
		} else if (split[1].equals(">")) {
			if (a > b) {
				return iftrue;
			} else {
				return iffalse;
			}
		} else if (split[1].equals(">=")) {
			if (a >= b) {
				return iftrue;
			} else {
				return iffalse;
			}
		} else if (split[1].equals("<=")) {
			if (a <= b) {
				return iftrue;
			} else {
				return iffalse;
			}
		}
		return iffalse;
	}
}
