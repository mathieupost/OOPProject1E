package nl.tudelft.excellence.utilities;

import nl.tudelft.excellence.exceptions.ParseArgumentsException;
import nl.tudelft.excellence.functions.BooleanFunction;
import nl.tudelft.excellence.functions.Function;
import nl.tudelft.excellence.functions.NumberFunction;
import nl.tudelft.excellence.functions.StringFunction;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.Cell;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FunctionManager {
	private static final List<String> operators = Arrays.asList(new String[]{"+", "-", "*", "/", "^", "<", ">", "=", "!"});
	static HashMap<String, Class<? extends Function>> functionList = new HashMap<String, Class<? extends Function>>();

	static {
		functionList = Utility.getFunctions();
	}

	/**
	 * @param name
	 * @return
	 */
	public static Class<? extends Function> getFunctionByName(String name) {
		return functionList.get(name.toUpperCase());
	}

	public static Constructor<? extends Function> getConstructor(String functionName, Class<?>... args) {
		Class<? extends Function> clazz = getFunctionByName(functionName);
		if (clazz == null) {
			return null;
		}

		try {
			return clazz.getConstructor(args);
		} catch (NoSuchMethodException e) {
			return null;
		}
	}

	public static String parseFunction(String functionString) throws Exception {
		String res = "";
		if (functionString.startsWith("="))
			functionString = functionString.substring(1);

		String functionName = functionString.substring(0, functionString.indexOf("("));

		String[] args = new String[0];
		try {
			args = parseArgs(functionString.substring(functionString.indexOf("(") + 1, functionString.lastIndexOf(")")));
		} catch (StringIndexOutOfBoundsException e) {
			throw new ParseArgumentsException("Error: Check your brackets!");
		}

		for (int i = 0; i < args.length; i++) {
			if (args[i].contains("("))
				args[i] = parseFunction(args[i]);
			else
				args[i] = Utility.getValue(args[i]);

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
			throw new Exception("Error: This function does not exists: " + functionName + "\n", e);
		} catch (NullPointerException e) {
			throw new Exception("Error: This function does not exists: " + functionName + "\n", e);
		} catch (InvocationTargetException e) {
			throw new Exception("Error: " + e.getCause().getMessage() + " in: " + functionString);
		}

		System.out.println(functionString + " = " + res);
		return res; //TODO return result
	}

	private static String[] parseArgs(String functionString) throws ParseArgumentsException{
		ArrayList<String> res = new ArrayList<>();
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
							Cell[] cells = SpreadSheet.current.getCells(res.get(res.size() - 1), arg);
							for (int cell = 1; cell < cells.length; cell++) { // Skip first because it is already added
								res.add(cells[cell].getData());
							}
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
			Cell[] cells = SpreadSheet.current.getCells(res.get(res.size() - 1), arg);
			for (int cell = 1; cell < cells.length; cell++) { // Skip first because it is already added
				res.add(cells[cell].getData());
			}
		} else
			res.add(arg);

		String[] resArgs = new String[res.size()];
		for (int i = 0; i < resArgs.length; i++) {
			resArgs[i] = res.get(i);
		}

		if(openBrackets != 0) {
			throw new ParseArgumentsException("Error: Check your brackets!");
		}

		return resArgs;
	}

	/**
	 * Converts an expression from infix to postfix (or RPN) notation using the Shunting-Yard algorithm
	 *
	 * @param expression The expression to convert
	 * @return The expression in postfix notation
	 */

	private static String infixToRPN(String expression) {
		ArrayList<String> outQ = new ArrayList<>();
		Stack<String> opStack = new Stack<>();
		String[] input = expression.split("(?<!^)");

		for (String token : input) {

		}
		return "";
	}

	private static String evaluate(String expr1, String expr2, char operand) {


		switch (operand) {
			case '+':
		}
		return "";
	}

	private static String prepareFunction(String function, char operator) {
		return "";
	}

}
