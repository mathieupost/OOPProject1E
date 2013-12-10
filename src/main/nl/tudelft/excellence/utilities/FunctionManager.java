package nl.tudelft.excellence.utilities;

import nl.tudelft.excellence.functions.Function;

import java.lang.reflect.Constructor;
import java.util.*;

public class FunctionManager {
	private static HashMap<String, Class<? extends Function>> functionList = new HashMap<String, Class<? extends Function>>();
    private static final List<String> operators = Arrays.asList(new String[]{"+", "-", "*", "/", "^", "<", ">", "=", "!"});
	
	static{
		functionList = Utility.getFunctions();
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Class<? extends Function> getFunctionByName(String name){
		return functionList.get(name.toUpperCase());
	}

    public static Constructor<? extends Function> getConstructor(String functionName, Class<?>... args){
        Class<? extends Function> clazz = getFunctionByName(functionName);
        if(clazz==null){
            return null;
        }

        try {
            return clazz.getConstructor(args);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
	
	public static String parseFunction(String function){
        if(function.startsWith("=")){
            return parseFunction(ExpressionParser.infixToRPN(function.substring(1)));
        }

        int openBrackets = 0, startIndex = 0;

        String[] split = new String[function.length()];
        System.arraycopy(function.split(""), 1, split, 0, split.length);

        String curChar, buffer = "";
        for(int i = 0; i<split.length; i++){
            curChar = split[i];
            if(operators.contains(curChar)){
                if(openBrackets==0){
                    return evaluate(parseFunction(buffer), parseFunction(function.substring(i+1)), curChar.charAt(0));
                } else {

                }
            } else if(curChar.equals("(")){

            } else if(curChar.equals(",")){

            } else if(curChar.equals(")")){

            } else if(!curChar.equals(" ")){
                buffer += curChar;
            }
        }

        return function; //TODO return result
    }

    /**
     * Converts an expression from infix to postfix (or RPN) notation using the Shunting-Yard algorithm
     * @param expression The expression to convert
     * @return The expression in postfix notation
     */
    private static String infixToRPN(String expression){
        ArrayList<String> outQ = new ArrayList<>();
        Stack<String> opStack = new Stack<>();
        String[] input = expression.split("(?<!^)");

        for(String token: input){

        }
        return "";
    }

    private static String evaluate(String expr1, String expr2, char operand){


        switch(operand){
            case '+':
        }
        return "";
    }

    private static String prepareFunction(String function, char operator){
        return "";
    }
	
}
