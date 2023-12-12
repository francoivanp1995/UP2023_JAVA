package Datos;

public class ValidationTextoException extends ValidationException {
	
	public ValidationTextoException() {
		
	}
	
	public ValidationTextoException(String message) {
		super(message);
	}
	
	public ValidationTextoException(Throwable cause) {
		super(cause);
	}
	
	public ValidationTextoException(String message, Throwable cause) {
		super(message,cause);
	}
	
}
