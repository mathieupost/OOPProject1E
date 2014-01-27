package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * The AVG function calculates the average of a set of numeric values.
 * <b>Syntax:</b> AVG(double a[, double b, double c...])
 */

public class AVG extends NumberFunction {
    public static final String[] aliases = new String[]{"AVERAGE", "GEMIDDELDE"};
    final static int MIN_ARGS = 2;

    private double[] input;

    public AVG(String... values) throws IllegalFunctionArgumentsException {
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
        double avg = 0;
        for (double anInput : input) {
            avg += anInput;
        }
        return avg / input.length;
    }
}
