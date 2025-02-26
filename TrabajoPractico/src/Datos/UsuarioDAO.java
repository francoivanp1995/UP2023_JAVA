package Datos;

import java.util.List;

public interface UsuarioDAO {
	
	void crearUsuario(UsuarioAlumno unUsuario);
	void eliminarUsuario(UsuarioAlumno unUsuario);
	void actualizarUsuario(UsuarioAlumno unUsuario);
	UsuarioAlumno muestraUsuario(String dni);
	List<UsuarioAlumno> listaTodosLosUsuarios();
	boolean buscarUsuario(UsuarioAlumno usuario);
}
