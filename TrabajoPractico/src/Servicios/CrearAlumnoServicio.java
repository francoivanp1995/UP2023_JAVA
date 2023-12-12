package Servicios;

import javax.swing.JOptionPane;

import Datos.UsuarioAlumno;
import Datos.UsuarioDAO;
import Datos.UsuarioDAOH2Impl;
import Presentacion.PanelCrearAlumno;
import Presentacion.PanelManager;

public class CrearAlumnoServicio {
	private UsuarioAlumno usuario;
	private PanelCrearAlumno panelCrearAlumno;
	private LibreriaValidaciones libreriaValidaciones;
	private PanelManager panelManager;
	private boolean verificado;
		
	public CrearAlumnoServicio(PanelCrearAlumno panelCrearAlumno, PanelManager panelManager) {
		super();
		this.panelCrearAlumno = panelCrearAlumno;
		this.panelManager = panelManager;
	}
	
	public void prueba() {
		try {
			panelCrearAlumno = new PanelCrearAlumno(panelManager);
			UsuarioAlumno usuario = new UsuarioAlumno();
			usuario = panelCrearAlumno.obtenerUsuarioIngresadoEnPanel();
			libreriaValidaciones = new LibreriaValidaciones();
			verificado = libreriaValidaciones.validarUsuario(usuario); 
			if(verificado) {
				UsuarioDAO dao = new UsuarioDAOH2Impl();
				dao.crearUsuario(usuario);
				JOptionPane.showMessageDialog(panelCrearAlumno, "Alumno creado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
				panelCrearAlumno.limpiarPanel();
			} else {
				JOptionPane.showMessageDialog(panelCrearAlumno, "Alumno no creado", "Atencion", JOptionPane.WARNING_MESSAGE);
				panelCrearAlumno.limpiarPanel();
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(panelCrearAlumno, "Alumno no creado", "Atencion", JOptionPane.WARNING_MESSAGE);
		}	
	}

}
