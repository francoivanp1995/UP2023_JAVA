package Servicios;

import javax.swing.JOptionPane;

import Datos.UsuarioAlumno;
import Datos.UsuarioDAO;
import Datos.UsuarioDAOH2Impl;
import Presentacion.PanelCrearAlumno;
import Presentacion.PanelManager;

public class UsuarioAlumnoServicio {
	
	public UsuarioAlumnoServicio() {
		
	}
	
	public void crearUsuario(UsuarioAlumno usuario) {
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		dao.crearUsuario(usuario);
	}
	
	public void actualizarUsuario(UsuarioAlumno usuario) {
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		dao.actualizarUsuario(usuario);
	}
	
	public void eliminarUsuario(UsuarioAlumno usuario) {
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		dao.eliminarUsuario(usuario);
	}
	
	public boolean buscarUsuario(UsuarioAlumno usuario) {
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		return (dao.buscarUsuario(usuario));
	}
}
