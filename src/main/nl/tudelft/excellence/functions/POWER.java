package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns base raised to the power exp<br>
 * <p/>
 * param base <br>
 * param exp <br>
 *
 * @return result
 */
public class POWER extends NumberFunction {
    public static final String[] aliases = new String[]{"MACHT"};
    private double base;
    private double exp;

    final static int MIN_ARGS = 2;
    final static int MAX_ARGS = 2;

    public POWER(String... values) throws IllegalFunctionArgumentsException {
        super(MIN_ARGS, MAX_ARGS, values);

        int cur = 0;
        try {
            base = Double.parseDouble(values[0]);
            cur++;
            exp = Double.parseDouble(values[1]);
        } catch (NumberFormatException e) {
            throw new IllegalFunctionArgumentsException("Expected a number, but got: '" + (values[cur].startsWith(" ") ? values[cur].substring(1) : values[cur]) + "'");
        }
    }

    public double execute() {
        return Math.pow(base, exp);
    }
}
