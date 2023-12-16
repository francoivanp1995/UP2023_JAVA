package Servicios;

import javax.swing.JOptionPane;

import Datos.UsuarioAlumno;
import Datos.UsuarioDAO;
import Datos.UsuarioDAOH2Impl;
import Presentacion.PanelCrearAlumno;
import Presentacion.PanelManager;

public class UsuarioServicio {
	
	public UsuarioServicio() {
		
	}
	
	public void crearUsuario(UsuarioAlumno usuario) {
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		dao.crearUsuario(usuario);
	}
	
	public void actualizarUsuario(UsuarioAlumno usuario) {
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		dao.actualizarUsuario(usuario);
	}
}
