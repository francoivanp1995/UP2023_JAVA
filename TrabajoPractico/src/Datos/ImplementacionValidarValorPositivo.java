package Datos;

public class ImplementacionValidarValorPositivo {
	
	public void validarValorPositivo(int num) throws ValidationNumeroException {
		if(num > Math.abs(num)) {
			throw new ValidationNumeroException("El valor es un numero negativo");
		} else {
			System.out.println("El valor es un numero positivo");
		}
	}

}
