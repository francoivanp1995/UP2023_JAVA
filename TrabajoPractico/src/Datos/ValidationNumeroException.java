package Datos;

public class ValidationNumeroException extends ValidationException{
	
	public ValidationNumeroException() {
		
	}
	
	public ValidationNumeroException(String message) {
		super(message);
	}
	
	public ValidationNumeroException(Throwable cause) {
		super(cause);
	}
	
	public ValidationNumeroException(String message, Throwable cause) {
		super(message,cause);
	}
}
