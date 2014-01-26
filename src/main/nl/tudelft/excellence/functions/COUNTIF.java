package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.utilities.Utility;

/**
 * Count how many cells in a given range meet a given logical condition
 * <b>Syntax:</b> COUNTIF(double criterium, String criteria_operand, double...cells
 */
public class COUNTIF extends NumberFunction {
    final static int MIN_ARGS = 2;

    private double[] cells;
    private String[] strings;
    private String criterium;
    private String operand;


    public COUNTIF(String... values) {
        super(MIN_ARGS, values);
        cells = new double[values.length - 2];
        strings = new String[cells.length];
        criterium = values[0].trim();
        operand = values[1];

        int cur = 2;
        try {
            if (Utility.isNumber(criterium) || !operand.matches("!?=")) {
                for (int i = 2; i < values.length; i++) {
                    cur = i;
                    cells[i - 2] = Double.parseDouble(values[i]);
                }
            } else {
                System.arraycopy(values, 2, strings, 0, values.length - 2);
            }
        } catch (NumberFormatException e) {
            throw new IllegalFunctionArgumentsException("Expected a number, but got: '" + (values[cur].startsWith(" ") ? values[cur].substring(1) : values[cur]) + "'");
        }
        if (!operand.matches("((!?=)|((<|>)=?))"))
            throw new IllegalFunctionArgumentsException("Invalid operand supplied: " + operand);
    }

    @Override
    public double execute() {
        double res = 0, numberCriterium = 0;
        boolean critIsNumber = true;

        try {
            numberCriterium = Double.parseDouble(criterium);
        } catch (NumberFormatException e) {
            critIsNumber = false;
            //If the criterium argument is a valid CellCoord, the referenced cell is empty, so treat it like such.
            if (new CellCoord(criterium).isValid()) {
                criterium = "";
            }
        }

        if (operand.equals("=")) {
            if (critIsNumber) {
                for (double cell : cells) {
                    if (cell == numberCriterium) {
                        res++;
                    }
                }
            } else {
                for (String cell : strings) {
                    if (cell.trim().equals(criterium)) {
                        res++;
                    }
                }
            }
        } else if (operand.equals("!=")) {
            if (critIsNumber) {
                for (double cell : cells) {
                    if (cell != numberCriterium) {
                        res++;
                    }
                }
            } else {
                for (String cell : strings) {
                    if (!cell.trim().equals(criterium)) {
                        res++;
                    }
                }
            }
        } else if (operand.equals("<")) {
            for (double cell : cells) {
                if (cell < numberCriterium) {
                    res++;
                }
            }
        } else if (operand.equals(">")) {
            for (double cell : cells) {
                if (cell > numberCriterium) {
                    res++;
                }
            }
        } else if (operand.equals("<=")) {
            for (double cell : cells) {
                if (cell <= numberCriterium) {
                    res++;
                }
            }
        } else if (operand.equals(">=")) {
            for (double cell : cells) {
                if (cell >= numberCriterium) {
                    res++;
                }
            }
        }

        return res;
    }
}

