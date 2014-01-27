package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;
import nl.tudelft.excellence.utilities.Utility;

/**
 * Returns true, when 1 or more input values is true, and returns false when all inputs are false
 * <b>Syntax:</b> OR(boolean a[, boolean b, boolean c...])
 */

public class OR extends BooleanFunction {
    public static final String[] aliases = new String[]{"OF"};
    final static int MIN_ARGS = 1;
    private boolean[] input;

    public OR(String... values) throws IllegalFunctionArgumentsException {
        super(MIN_ARGS, values);

        input = new boolean[values.length];

        for (int i = 0; i < values.length; i++) {
            if (!Utility.isBoolean(values[i])) {
                throw new IllegalFunctionArgumentsException("Expected a boolean, but got: '" + (values[i].startsWith(" ") ? values[i].substring(i) : values[i]) + "'");
            }
            input[i] = Boolean.parseBoolean(values[i].trim());
        }
    }

    @Override
    public boolean execute() {
        boolean result = false;
        for (boolean anInput : input) {
            if (anInput) {
                result = true;
            }
        }
        return result;
    }

}
