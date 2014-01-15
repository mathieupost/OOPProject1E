package nl.tudelft.excellence.exceptions;

public class ParseArgumentsException extends IllegalArgumentException {
	public ParseArgumentsException(){super();}
	public ParseArgumentsException(String message){super(message);}
	public ParseArgumentsException(String message, Throwable cause) { super(message, cause); }
	public ParseArgumentsException(Throwable cause) { super(cause); }
}
