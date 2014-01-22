package nl.tudelft.excellence.exceptions;

public class SaveNotNeededException extends Exception {
	public SaveNotNeededException(String message) {super(message);}
	public SaveNotNeededException(Throwable cause) {super(cause);}
	public SaveNotNeededException(String message, Throwable cause) {super(message, cause);}
	public SaveNotNeededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {super(message, cause, enableSuppression, writableStackTrace);}
}
