package Datos;

public class ImplementacionValidarTextoVacio implements InterfazValidacionTextoVacio{

	public boolean validarTextoVacio(String texto) throws ValidationTextoException {
		if(texto.isEmpty()) {
			throw new ValidationTextoException("El campo es vacio");
		} else {
			return true;
		}
	}
}