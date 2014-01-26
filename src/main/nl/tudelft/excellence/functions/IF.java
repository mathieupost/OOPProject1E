package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.utilities.Utility;

/**
 * Converts a String into a logical condition and tests that condition<br>
 * Returns a given String if the test returns true, returns another given String if the test returns false<br>
 * param iftrue String which is to be returned if the logical condition returns true<br>
 * param iffalse String which is to be returned if the logical condition returns false<br>
 */
public class IF extends StringFunction {
    private String logictest;
    private String iftrue;
    private String iffalse;

    final static int MIN_ARGS = 1;
    final static int MAX_ARGS = 3;

    public IF(String... values) throws IllegalFunctionArgumentsException {
        super(MIN_ARGS, MAX_ARGS, values);

        if (values.length == 2) {
            throw new IllegalFunctionArgumentsException("This function expects either 1 or 3 arguments");
        }

        logictest = Utility.getValue(values[0].trim());

        this.logictest = logictest.replaceFirst("((!?=)|((<|>)=?))", "|$0|");

        if (values.length == 3) {
            iftrue = values[1];
            iffalse = values[2];
        } else {
            iftrue = "true";
            iffalse = "false";
        }

        if (!Utility.isBoolean(logictest)) {
            String[] split = logictest.split("\\|");
            if (!split[1].matches("!?=")) { //If we're testing an (in)equality arguments don't have to be numbers
                int cur = 0;
                try {
                    Double.parseDouble(Utility.getValue(split[0]));
                    cur = 2;
                    Double.parseDouble(Utility.getValue(split[2]));
                } catch (NumberFormatException e) {
                    throw new IllegalFunctionArgumentsException("Expected a number, but got: " + split[cur]);
                }
            }
        }
    }

    @Override
    public String execute() {
        if (Utility.isBoolean(logictest)) {
            return (Boolean.parseBoolean(logictest.trim())) ? iftrue : iffalse;
        }

        String[] split = logictest.split("\\|");
        double a = 0, b = 0;
        boolean notNumbers = false;
        String first = Utility.getValue(split[0]), second = Utility.getValue(split[2]);
        try {
            a = Double.parseDouble(first);
            b = Double.parseDouble(second);
        } catch (NumberFormatException e) {
            notNumbers = true;
            //If the first or second argument is a valid CellCoord, the referenced cell is empty, so treat it like such.
            if (new CellCoord(first).isValid()) {
                first = "";
            }
            if (new CellCoord(second).isValid()) {
                second = "";
            }
        }

        if (split[1].equals("=")) {
            if (notNumbers) {
                return (first.equals(second)) ? iftrue : iffalse;
            } else {
                return (a == b) ? iftrue : iffalse;
            }
        } else if (split[1].equals("!=")) {
            if (notNumbers) {
                return (!first.equals(second)) ? iftrue : iffalse;
            } else {
                return (a != b) ? iftrue : iffalse;
            }
        } else if (split[1].equals("<")) {
            return (a < b) ? iftrue : iffalse;
        } else if (split[1].equals(">")) {
            return (a > b) ? iftrue : iffalse;
        } else if (split[1].equals(">=")) {
            return (a >= b) ? iftrue : iffalse;
        } else if (split[1].equals("<=")) {
            return (a <= b) ? iftrue : iffalse;
        }
        return iffalse;
    }
}
