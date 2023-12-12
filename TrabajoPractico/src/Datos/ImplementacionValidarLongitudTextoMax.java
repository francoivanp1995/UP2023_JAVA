package Datos;

public class ImplementacionValidarLongitudTextoMax {
	
	public void validarLongitudTexto(String texto, int max) throws ValidationTextoException{
		if(texto.length() > max) {
			throw new ValidationTextoException("Los caracteres del texto exceden al maximo permitido");
		} else {
			System.out.println("Los caracteres del texto son permitidos");
		}
	}

}
