package Datos;

import Servicios.LibreriaValidaciones;

public class ImplementacionValidacionCamposUsuario {

	private ImplementacionValidarTextoVacio implTextoVacio;
	private boolean validado;
	
	
	 public ImplementacionValidacionCamposUsuario() {

	    }
	 
	public boolean validaCamposUsuario(UsuarioAlumno usuario) throws ValidationUsuarioException {
			try {
				implTextoVacio = new ImplementacionValidarTextoVacio();
				boolean dni = implTextoVacio.validarTextoVacio(usuario.getDni());
				boolean nombre = implTextoVacio.validarTextoVacio(usuario.getNombre());
				boolean apellido = implTextoVacio.validarTextoVacio(usuario.getApellido());
				boolean nombreDeUsuario = implTextoVacio.validarTextoVacio(usuario.getNombreDeUsuario());
				boolean email = implTextoVacio.validarTextoVacio(usuario.getEmail());
				boolean contrasenia = implTextoVacio.validarTextoVacio(usuario.getContrasenia());
//				boolean tipo = implTextoVacio.validarTextoVacio(usuario.getTipo());
				
				if(dni && nombre && apellido && nombreDeUsuario && email && contrasenia) {
					return true;
				} else {
					return false;
				}

	         	} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
}
