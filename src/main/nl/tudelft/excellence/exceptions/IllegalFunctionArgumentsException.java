package nl.tudelft.excellence.exceptions;

public class IllegalFunctionArgumentsException extends IllegalArgumentException {
    public IllegalFunctionArgumentsException(){super();}
    public IllegalFunctionArgumentsException(String message){super(message);}
    public IllegalFunctionArgumentsException(String message, Throwable cause) { super(message, cause); }
    public IllegalFunctionArgumentsException(Throwable cause) { super(cause); }
}
