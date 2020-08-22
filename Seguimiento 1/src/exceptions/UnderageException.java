package exceptions;

public class UnderageException extends Exception{
	
	public UnderageException() {
		super("The age is not allowed");
	}

}
