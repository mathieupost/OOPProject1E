package nl.tudelft.excellence.utilities;

import nl.tudelft.excellence.exceptions.ParseArgumentsException;
import nl.tudelft.excellence.functions.BooleanFunction;
import nl.tudelft.excellence.functions.Function;
import nl.tudelft.excellence.functions.NumberFunction;
import nl.tudelft.excellence.functions.StringFunction;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.spreadsheet.cells.FunctionCell;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class FunctionManager {
    private static final HashMap<String, Class<? extends Function>> functionList;
    private static final ArrayList<FunctionCell> recursionDetectList = new ArrayList<FunctionCell>();

    static {
        functionList = Utility.getFunctions();
    }

    /**
     * @param name The name of the function (Case-insensitive)
     * @return The Class<? extends Function> object or null if it doesn't exist
     */
    public static Class<? extends Function> getFunctionByName(String name) {
        return functionList.get(name.toUpperCase());
    }

    public static String parseFunction(String functionString) throws Exception {
        String res = "";
        if (functionString.startsWith("="))
            functionString = functionString.substring(1);

        CellCoord coord = new CellCoord(functionString);
        if (coord.isValid()) {
            Cell cell = SpreadSheet.current.getCell(coord);
            if (cell != null) {
                if (cell.getRawData().equalsIgnoreCase("=" + functionString)) {
                    throw new ParseArgumentsException("Error: Recursive Cell pointer");
                } else {
                    FunctionCell fCell = null;
                    if (cell instanceof FunctionCell) {
                        fCell = (FunctionCell) cell;
                        if (!recursionDetectList.contains(fCell)) {
                            recursionDetectList.add(fCell);
                        } else {
                            recursionDetectList.clear();
                            throw new ParseArgumentsException("Error: Recursive Cell pointer");
                        }
                    }
                    String data = cell.getData();
                    recursionDetectList.remove(fCell);
                    return data;
                }
            } else {
                throw new ParseArgumentsException("#Cell '" + functionString + "' is empty.");
            }
        }

        String functionName;
        try {
            functionName = functionString.substring(0, functionString.indexOf("("));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ParseArgumentsException("Error: No function or (valid) coordinate found after the '='");
        }

        String[] args;
        try {
            args = parseArgs(functionString.substring(functionString.indexOf("(") + 1, functionString.lastIndexOf(")")));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ParseArgumentsException("Error: Check your brackets!");
        }

        for (int i = 0; i < args.length; i++) {
            if (!args[i].contains("Error:") && args[i].contains("("))
                args[i] = parseFunction(args[i]);
            else {
                Cell cell = SpreadSheet.current.getCell(new CellCoord(args[i]));
                if (cell != null) {
                    FunctionCell fCell = null;
                    if (cell instanceof FunctionCell) {
                        fCell = (FunctionCell) cell;
                        if (!recursionDetectList.contains(fCell)) {
                            recursionDetectList.add(fCell);
                        } else {
                            recursionDetectList.clear();
                            throw new ParseArgumentsException("Recursive Cell pointer in '" + cell.getRawData() + "'");
                        }
                    }
                    args[i] = cell.getData();
                    recursionDetectList.remove(fCell);
                }
            }

            if (args[i].toUpperCase().contains("ERROR"))
                throw new ParseArgumentsException("A referenced cell contains an error");
        }

        try {
            Class<? extends Function> clazz = getFunctionByName(functionName);
            Function function = (Function) clazz.getConstructors()[0].newInstance(new Object[]{args});
            if (NumberFunction.class.isAssignableFrom(clazz)) {
                NumberFunction numberFunction = (NumberFunction) function;
                res = Double.toString(numberFunction.execute());
            } else if (BooleanFunction.class.isAssignableFrom(clazz)) {
                BooleanFunction booleanFunction = (BooleanFunction) function;
                res = Boolean.toString(booleanFunction.execute());
            } else if (StringFunction.class.isAssignableFrom(clazz)) {
                StringFunction stringFunction = (StringFunction) function;
                res = stringFunction.execute();
            }
        } catch (InstantiationException e) {
            throw new Exception("Error: This function does not exist: " + functionName, e);
        } catch (NullPointerException e) {
            throw new Exception("Error: This function does not exist: " + functionName, e);
        } catch (InvocationTargetException e) {
            throw new Exception("Error: " + e.getCause().getMessage() + " in: " + functionString);
        }

        //System.out.println(functionString + " = " + res);
        return res;
    }

    private static String[] parseArgs(String functionString) throws ParseArgumentsException {
        ArrayList<String> res = new ArrayList<String>();
        char[] functionStringChars = functionString.toCharArray();
        int openBrackets = 0;
        char previous = ' ';
        String arg = "";
        for (char charr : functionStringChars) {
            switch (charr) {
                case ':':
                    if (openBrackets == 0) {
                        previous = charr;
                        res.add(arg);
                        arg = "";
                    } else
                        arg += charr;
                    break;
                case '(':
                    arg += charr;
                    openBrackets++;
                    previous = charr;
                    break;
                case ')':
                    arg += charr;
                    openBrackets--;
                    break;
                case ';':
                    if (openBrackets == 0) {
                        if (previous == ':') {
                            String from = res.get(res.size() - 1);
                            ArrayList<String> cellCoords = SpreadSheet.current.getCellCoords(from, arg);
                            if (cellCoords == null)
                                throw new ParseArgumentsException("Error: Specified range '" + from + ":" + arg + "' is invalid.");
                            cellCoords.remove(0); // Remove first because it is already added
                            res.addAll(cellCoords);
                        } else
                            res.add(arg);
                        arg = "";
                        previous = charr;
                    } else {
                        arg += charr;
                    }
                    break;
                default:
                    arg += charr;
                    break;
            }
        }
        // add last arg
        if (previous == ':') {
            String from = res.get(res.size() - 1);
            ArrayList<String> cellCoords = SpreadSheet.current.getCellCoords(from, arg);
            if (cellCoords == null)
                throw new ParseArgumentsException("Error: Specified range '" + from + ":" + arg + "' is invalid.");
            cellCoords.remove(0); // Remove first because it is already added
            res.addAll(cellCoords);
        } else
            res.add(arg);

        if (openBrackets != 0) {
            throw new ParseArgumentsException("Error: Check your brackets!");
        }

        return res.toArray(new String[res.size()]);
    }
}
