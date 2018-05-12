package exception;

public class InvalidQueryException extends Exception {

	public InvalidQueryException() {
		super("Invalid query format!");
	}
	
}
