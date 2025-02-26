package Datos;

public class AutenticationUsuarioException extends ValidationException{

	public AutenticationUsuarioException() {
		
	}
	
	public AutenticationUsuarioException(String message) {
		super(message);
	}
	
	public AutenticationUsuarioException(Throwable cause) {
		super(cause);
	}
	
	public AutenticationUsuarioException(String message, Throwable cause) {
		super(message,cause);
	}
}
