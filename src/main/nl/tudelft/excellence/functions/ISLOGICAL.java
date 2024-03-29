package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;
import nl.tudelft.excellence.utilities.Utility;

/**
 * Checks if a given String is a representation of a logical value
 * <b>Syntax:</b> ISLOGICAL(String value)
 */
public class ISLOGICAL extends BooleanFunction {
    public static final String[] aliases = new String[]{"ISLOGISCH"};
    private String value;

    final static int MIN_ARGS = 1;
    final static int MAX_ARGS = 1;

    public ISLOGICAL(String... values) throws IllegalFunctionArgumentsException {
        super(MIN_ARGS, MAX_ARGS, values);
        value = values[0];
    }

    @Override
    public boolean execute() {
        return Utility.isBoolean(value);
    }
}
