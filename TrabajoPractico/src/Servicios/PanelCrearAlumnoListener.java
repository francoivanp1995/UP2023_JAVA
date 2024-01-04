package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datos.ImplementacionValidacionCamposUsuario;
import Datos.UsuarioAlumno;
import Datos.UsuarioDAO;
import Datos.UsuarioDAOH2Impl;
import Presentacion.PanelCrearAlumno;
import Presentacion.PanelManager;
import Servicios.UsuarioAlumnoServicio;

public class PanelCrearAlumnoListener implements ActionListener{
	
	PanelCrearAlumno panelCrearAlumno;
	PanelManager panelManager;
	LibreriaValidaciones libreriaValidaciones;
	Boolean verificado; 
	UsuarioAlumnoServicio crearAlumnoServicio;
	
	public PanelCrearAlumnoListener(PanelCrearAlumno panelCrearAlumno, PanelManager panelManager) {
		super();
		this.panelCrearAlumno = panelCrearAlumno;
		this.panelManager = panelManager;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panelCrearAlumno.getCrearBoton()) {
			try {
				UsuarioAlumno usuario = new UsuarioAlumno();
				usuario = panelCrearAlumno.obtenerUsuarioIngresadoEnPanel();
				libreriaValidaciones = new LibreriaValidaciones();
				verificado = libreriaValidaciones.validarUsuario(usuario); 
				if(verificado) {
					crearAlumnoServicio = new UsuarioAlumnoServicio();
					crearAlumnoServicio.crearUsuario(usuario);
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
			
		} else if (e.getSource() == panelCrearAlumno.getCancelarBoton()) {
			try {
				panelManager.mostrarPantallaAdministrador();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
