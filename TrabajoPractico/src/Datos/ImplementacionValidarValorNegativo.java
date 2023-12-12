package Datos;

public class ImplementacionValidarValorNegativo {
	
	public void validarValorNegativo(int num) throws ValidationNumeroException{
		if(num < Math.abs(num)) {
			throw new ValidationNumeroException("El valor es un numero negativo");
		} else {
			System.out.println("El valor es un numero positivo");
		}
	}

}
