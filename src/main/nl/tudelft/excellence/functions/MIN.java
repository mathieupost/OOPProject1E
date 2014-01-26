package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns the minimum of all inserted values
 * <b>Syntax:</b> MIN(double a, double... values)
 */
public class MIN extends NumberFunction {

    private double[] input;
    final static int MIN_ARGS = 1;

    public MIN(String... values) throws IllegalFunctionArgumentsException {
        super(MIN_ARGS, values);
        input = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            try {
                input[i] = Double.parseDouble(values[i]);
            } catch (NumberFormatException e) {
                throw new IllegalFunctionArgumentsException("Expected a number, but got: '" + (values[i].startsWith(" ") ? values[i].substring(1) : values[i]) + "'");
            }
        }
    }

    @Override
    public double execute() {
        double min = Integer.MAX_VALUE;
        for (double anInput : input) {
            if (anInput < min)
                min = anInput;
        }
        return min;
    }
}


