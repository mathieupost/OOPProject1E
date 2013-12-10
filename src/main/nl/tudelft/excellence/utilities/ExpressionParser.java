package nl.tudelft.excellence.utilities;

import java.util.*;

public class ExpressionParser {
    // Associativity constants for operators
    private static final int LEFT_ASSOC  = 0;
    private static final int RIGHT_ASSOC = 1;

    // Operators
    private static final Map<String, int[]> OPERATORS = new HashMap<>();
    static {
        // Map<"token", []{precedence, associativity}>
        OPERATORS.put("+", new int[] { 2, LEFT_ASSOC });
        OPERATORS.put("-", new int[] { 2, LEFT_ASSOC });
        OPERATORS.put("*", new int[] { 3, LEFT_ASSOC });
        OPERATORS.put("/", new int[] { 3, LEFT_ASSOC });
        OPERATORS.put("^", new int[] { 4, RIGHT_ASSOC});
    }

    /**
     * Test if a token is an operator
     * @param token The token to check
     * @return Whether or not the token is an operator
     */
    private static boolean isOperator(String token){
        return OPERATORS.containsKey(token);
    }

    /**
     * Test associativity of operator token
     * @param token The operator token to check the associativity of
     * @param type The associativity type to check for
     * @return Whether or not the token has the 'type' associativity
     */
    private static boolean isAssociative(String token, int type){
        if (!isOperator(token))
        {
            throw new IllegalArgumentException("Invalid token: " + token);
        }

        if (OPERATORS.get(token)[1] == type) {
            return true;
        }
        return false;
    }

    /**
     * Compare precedence of operators.
     * @param token1 The first operator to use when comparing
     * @param token2 The second operator to use when comparing
     * @return Whether or not token1 comes before token2 (yes if > 0, no if < 0 and same if = 0)
     */
    private static final int cmpPrecedence(String token1, String token2){
        if (!isOperator(token1) || !isOperator(token2))
        {
            throw new IllegalArgumentException("Invalid tokens: " + token1
                    + " " + token2);
        }
        return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
    }

    /**
     * Escape the excellence function brackets to make sure they can be restored after applying the Shunting-Yard algorithm
     * @param input The input tokens to apply the escape method on
     * @return The escaped array of input tokens
     */
    private static String[] escapeFunctions(String[] input){
        String token;
        int openBrackets = 0, openFunctions = 0;
        for(int i = 0; i<input.length; i++){
            token = input[i];
            if(token.equals("(") && i>0){
                openBrackets++;
                if(Character.isLetter(input[i-1].charAt(0))){
                    openFunctions++;
                    input[i] = "[";
                }
            } else if (token.equals(")")){
                if(openFunctions==openBrackets){
                    openFunctions--;
                    input[i] = "]";
                }
                openBrackets--;
            }
        }
        /**
         * TODO: while(openFunctions>0){ add "]"; openFunctions--; openBrackets--;} while(openBrackets>0){ add ")"; openBrackets--;}
         */
        return input;
    }

    /**
     * Restore the escaped brackets
     * @param input The input tokens to apply the unescape method on
     * @return The unescaped String
     */
    private static String unescapeFunctions(String[] input){
        String output = Arrays.toString(input);
        return output.replaceAll("\\[", "(").replaceAll("]", ")");
    }

    /**
     * Converts an expression from infix to postfix (or RPN) notation using the Shunting-Yard algorithm
     * @param input The expression to convert
     * @return The expression in postfix notation
     */
    public static String infixToRPN(String input){ //TODO properly propagate expressions of multiple tokens (might have to be done after getting the output)
        ArrayList<String> out = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        String[] inputTokens = escapeFunctions(input.split("(?<!^)"));

        // For each token
        for (String token : inputTokens){
            // If token is an operator
            if (isOperator(token)){
                // While stack not empty AND stack top element
                // is an operator
                while (!stack.empty() && isOperator(stack.peek())){
                    if ((isAssociative(token, LEFT_ASSOC)         &&
                            cmpPrecedence(token, stack.peek()) <= 0) ||
                            (isAssociative(token, RIGHT_ASSOC)        &&
                                    cmpPrecedence(token, stack.peek()) < 0))
                    {
                        out.add(stack.pop());
                        continue;
                    }
                    break;
                }
                // Push the new operator on the stack
                stack.push(token);
            }
            // If token is a left bracket '('
            else if (token.equals("(")){
                stack.push(token);  //
            }
            // If token is a right bracket ')'
            else if (token.equals(")")){
                while (!stack.empty() && !stack.peek().equals("(")){
                    out.add(stack.pop());
                }
                stack.pop();
            }
            // If token is a number
            else {
                out.add(token);
            }
        }
        while (!stack.empty()){
            out.add(stack.pop());
        }
        return unescapeFunctions(out.toArray(new String[out.size()]));
    }
}
