package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;
import nl.tudelft.excellence.utilities.Utility;

/**
 * Converts a String into a logical condition and tests that condition
 * Returns a given String if the test returns true, returns another given String if the test returns false
 * @param iftrue String which is to be returned if the logical condition returns true
 * @param iffalse String which is to be returned if the logical condition returns false
 */
public class IF extends StringFunction {
	private String logictest;
	private String iftrue;
	private String iffalse;
	private boolean isLogicValue;
	
	final static int MIN_ARGS = 1;

	public IF(String...strings) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS, strings);

		if (strings.length == 2) {
			throw new IllegalFunctionArgumentsException("This function needs 1 argument or 3 or more arguments");
		}

		logictest = Utility.getValue(strings[0].trim());
		isLogicValue = logictest.equalsIgnoreCase("true") || logictest.equalsIgnoreCase("false");

		this.logictest = logictest.replaceFirst("((!?=)|((<|>)=?))", "|$0|");
		System.out.println("logictest = " + logictest);

		if (strings.length >= 3) {
			iftrue = strings[1];
			iffalse = strings[2];
		} else {
			iftrue = "true";
			iffalse = "false";
		}
	}

	@Override
	public String execute() {
		if(isLogicValue){
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
