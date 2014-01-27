package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns the square root of double x<br>
 * <p/>
 * param x<br>
 *
 * @return square root
 */
public class SQRT extends NumberFunction {
    public static final String[] aliases = new String[]{"WORTEL"};
    private double input;

    final static int MIN_ARGS = 1;
    final static int MAX_ARGS = 1;

    public SQRT(String... values) throws IllegalFunctionArgumentsException {
        super(MIN_ARGS, values);

        try {
            input = Double.parseDouble(values[0]);
        } catch (NumberFormatException e) {
            throw new IllegalFunctionArgumentsException("Expected a number, but got: '" + (values[0].startsWith(" ") ? values[0].substring(1) : values[0]) + "'");
        }
    }

    @Override
    public double execute() {
        return Math.sqrt(input);
    }

}
