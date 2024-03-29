package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;
import nl.tudelft.excellence.utilities.Utility;

/**
 * Return the NOT value
 * <b>Syntax:</b> NOT(boolean value)
 */
public class NOT extends BooleanFunction {
    public static final String[] aliases = new String[]{"NIET"};
    boolean input;
    final static int MIN_ARGS = 1;
    final static int MAX_ARGS = 1;

    public NOT(String... values) throws IllegalFunctionArgumentsException {
        super(MIN_ARGS, MAX_ARGS, values);

        if (!Utility.isBoolean(values[0])) {
            throw new IllegalFunctionArgumentsException("Expected a boolean, but got: '" + (values[0].startsWith(" ") ? values[0].substring(1) : values[0]) + "'");
        }
        input = Boolean.parseBoolean(values[0].trim());

    }


    @Override
    public boolean execute() {
        return !input;
    }
}