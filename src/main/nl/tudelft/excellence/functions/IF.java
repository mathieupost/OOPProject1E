package nl.tudelft.excellence.functions;

/**
 * Converts a String into a logical condition and tests that condition
 * Returns a given String if the test returns true, returns another given String if the test returns false
 * @param iftrue String which is to be returned if the logical condition returns true
 * @param iffalse String which is to be returned if the logical condition returns false
 */
public class IF extends StringFunction {
	private String[] split;
	private double a;
	private double b;
	private String iftrue;
	private String iffalse;

	public IF(String logictest, String iftrue1, String iffalse1) {
		split = logictest.split(" ");
		a = Double.parseDouble(split[0]);
		b = Double.parseDouble(split[2]);
		iftrue = iftrue1;
		iffalse = iffalse1;
	}

	@Override
	public String execute() {
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
