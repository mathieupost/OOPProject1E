package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Checks if a given double is an even number
 * <b>Syntax:</b> ISEVEN(double value)
 */
public class ISEVEN extends BooleanFunction {
    public static final String[] aliases = new String[]{"IS.EVEN"};
    final static int MIN_ARGS = 1;
    final static int MAX_ARGS = 1;

    private double result;

    public ISEVEN(String... values) throws IllegalFunctionArgumentsException {
        super(MIN_ARGS, MAX_ARGS, values);

        try {
            result = Double.parseDouble(values[0]);
        } catch (NumberFormatException e) {
            throw new IllegalFunctionArgumentsException("Expected a number, but got: '" + (values[0].startsWith(" ") ? values[0].substring(1) : values[0]) + "'");
        }

    }

    @Override
    public boolean execute() {
        return ((int) result) % 2 == 0;
    }
}
