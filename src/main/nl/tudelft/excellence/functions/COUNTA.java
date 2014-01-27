package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;

/**
 * This function counts how many cells in a given range are not empty.
 * <b>Syntax:</b> COUNTA(String a[, String b, String c...])
 */

public class COUNTA extends NumberFunction {
    public static final String[] aliases = new String[]{"AANTALARG"};
    final static int MIN_ARGS = 1;

    private String[] cells;

    public COUNTA(String... strings) throws IllegalFunctionArgumentsException {
        super(MIN_ARGS, strings);
        cells = strings;
    }

    @Override
    public double execute() {
        double result = 0;
        CellCoord temp;
        for (String cell : cells) {
            temp = new CellCoord(cell);
            if (!temp.isValid() || SpreadSheet.current.getCell(temp) != null) {
                result++;
            }
        }
        System.out.println();
        return result;
    }

}
