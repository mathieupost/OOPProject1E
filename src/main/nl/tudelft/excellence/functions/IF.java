package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Converts a String into a logical condition and tests that condition
 * Returns a given String if the test returns true, returns another given String if the test returns false
 * @param iftrue String which is to be returned if the logical condition returns true
 * @param iffalse String which is to be returned if the logical condition returns false
 */
public class IF extends StringFunction {
	private String logictest;
	private double a;
	private double b;
	private String iftrue;
	private String iffalse;
	private boolean isLogicValue;
	
	final static int MIN_ARGS = 3;

	public IF(String...strings) throws IllegalFunctionArgumentsException{
		super(MIN_ARGS,strings);
		logictest = strings[0].trim();
		isLogicValue = logictest.equalsIgnoreCase("true") || logictest.equalsIgnoreCase("false");
			
		this.logictest = logictest.replaceFirst("((!?=)|((<|>)=?))", "|$0|");;
		iftrue = strings[1];
		iffalse = strings[2];
	}

	@Override
	public String execute() {
		if(isLogicValue){
			return (Boolean.parseBoolean(logictest))?iftrue:iffalse;
		}
		
		String[] split = logictest.split("\\|");
		a = Double.parseDouble(split[0]);
		b = Double.parseDouble(split[2]);
		
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
