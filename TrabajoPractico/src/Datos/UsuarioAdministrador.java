package Datos;

public class UsuarioAdministrador extends UsuarioBase{
	
	public UsuarioAdministrador() {
		
	}
	
	public UsuarioAdministrador(String dni, String nombre, String apellido, String nombreDeUsuario, String email, String contrasenia, String tipo) {
		super(dni,nombre,apellido,nombreDeUsuario,email,contrasenia,tipo);
	}
}
