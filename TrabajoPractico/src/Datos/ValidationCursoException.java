package Datos;

public class ValidationCursoException extends ValidationException{


		public ValidationCursoException() {
			
		}
		
		public ValidationCursoException(String message) {
			super(message);
		}
		
		public ValidationCursoException(Throwable cause) {
			super(cause);
		}
		
		public ValidationCursoException(String message, Throwable cause) {
			super(message,cause);
		}

}