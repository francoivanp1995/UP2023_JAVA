package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datos.UsuarioAlumno;
import Datos.UsuarioDAO;
import Datos.UsuarioDAOH2Impl;
import Presentacion.PanelEditarCamposAlumno;
import Presentacion.PanelManager;
import Presentacion.PanelModificarAlumno;

public class PanelEditarCamposAlumnoListener implements ActionListener{
	
	private PanelEditarCamposAlumno panelEditarCamposAlumno;
	private PanelManager panelManager;
	private LibreriaValidaciones libreriaValidaciones;
	private UsuarioAlumno usuario;
	private PanelModificarAlumno panelModificarAlumno;
	private boolean validado;
	
	public PanelEditarCamposAlumnoListener(PanelEditarCamposAlumno panelEditarCamposAlumno, PanelManager panelManager) {
		this.panelEditarCamposAlumno = panelEditarCamposAlumno;
		this.panelManager = panelManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panelEditarCamposAlumno.getGuardarBoton()) {
			try {
				libreriaValidaciones = new LibreriaValidaciones();
				usuario = new UsuarioAlumno();
				usuario = panelEditarCamposAlumno.setUsuarioIngresadoEnPanel();
				validado = libreriaValidaciones.validarUsuario(usuario);
				if(validado) {
					UsuarioDAO dao = new UsuarioDAOH2Impl();
					dao.actualizarUsuario(usuario);
					JOptionPane.showMessageDialog(panelEditarCamposAlumno, "Alumno Modificado","Mensaje", JOptionPane.INFORMATION_MESSAGE);
					panelEditarCamposAlumno.limpiarPanel();
					panelManager.mostrarPantallaModificarAlumno();
				} else {
					JOptionPane.showMessageDialog(panelEditarCamposAlumno, "Alumno no valido","atencion", JOptionPane.WARNING_MESSAGE);
					panelEditarCamposAlumno.limpiarPanel();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == panelEditarCamposAlumno.getCancelarBoton()) {
			panelManager.mostrarPantallaModificarAlumno();
		}
	}

}
