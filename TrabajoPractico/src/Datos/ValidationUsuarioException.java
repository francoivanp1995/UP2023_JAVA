package Datos;

public class ValidationUsuarioException extends ValidationException{
	
	public ValidationUsuarioException() {
		
	}
	
	public ValidationUsuarioException(String message) {
		super(message);
	}
	
	public ValidationUsuarioException(Throwable cause) {
		super(cause);
	}
	
	public ValidationUsuarioException(String message, Throwable cause) {
		super(message,cause);
	}

}
