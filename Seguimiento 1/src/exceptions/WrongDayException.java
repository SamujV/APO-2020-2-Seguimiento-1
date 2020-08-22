package exceptions;

public class WrongDayException extends Exception {
	
	public WrongDayException() {
		super("By the law you are not allowed to come in today ");
	}

}
