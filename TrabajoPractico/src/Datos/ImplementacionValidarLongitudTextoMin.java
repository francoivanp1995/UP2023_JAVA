package Datos;

public class ImplementacionValidarLongitudTextoMin implements InterfazValidacionLongTex{
	
	public void validarLongitudTexto(String texto, int min) throws ValidationTextoException {
		if(texto.length() < min) {
			throw new ValidationTextoException("Los caracteres del texto no superan el minimo requerido");
		} else {
			System.out.println("Los caracteres del texto son permitidos");
		}
	}

}
