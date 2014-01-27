package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Returns the sum of double a and double b
 * <b>Syntax:</b> SUM(double a, double b, double... values)
 */
public class SUM extends NumberFunction {
    public static final String[] aliases = new String[]{"SOM"};
    private double[] input;

    final static int MIN_ARGS = 2;

    public SUM(String... values) throws IllegalFunctionArgumentsException {
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
        double sum = 0;
        for (double value : input) {
            sum += value;
        }
        return sum;
    }
}
