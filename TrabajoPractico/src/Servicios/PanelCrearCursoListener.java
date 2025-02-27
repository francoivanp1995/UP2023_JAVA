package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datos.CursoClase;
import Datos.UsuarioAlumno;
import Presentacion.PanelCrearAlumno;
import Presentacion.PanelCrearCurso;
import Presentacion.PanelManager;

public class PanelCrearCursoListener implements ActionListener {

	PanelCrearCurso panelCrearCurso;
	PanelManager panelManager;
	LibreriaValidaciones libreriaValidaciones;
	Boolean verificado; 
	CursoServicio crearCursoServicio;
	
	public PanelCrearCursoListener(PanelCrearCurso panelCrearCurso, PanelManager panelManager) {
		super();
		this.panelCrearCurso = panelCrearCurso;
		this.panelManager = panelManager;
	}
	
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == panelCrearCurso.getBotoneraPanel().getOkBtn()) {
	        procesarCreacionCurso();
	    } else if (e.getSource() == panelCrearCurso.getBotoneraPanel().getCancelBtn()) {
	        cancelarCreacionCurso();
	    }
	}

	private void procesarCreacionCurso() {
	    try {
	        CursoClase curso = panelCrearCurso.obtenerCursoIngresadoEnPanel();
	        libreriaValidaciones = new LibreriaValidaciones();
	        verificado = libreriaValidaciones.validarCurso(curso); 
	        if (verificado) {
	            crearCursoServicio = new CursoServicio();
	            crearCursoServicio.crearCurso(curso);
	            JOptionPane.showMessageDialog(panelCrearCurso, "Curso creado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            panelCrearCurso.limpiarPanel();
	        } else {
	            JOptionPane.showMessageDialog(panelCrearCurso, "Los datos del curso no son válidos", "Atención", JOptionPane.WARNING_MESSAGE);
	            panelCrearCurso.limpiarPanel();
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(panelCrearCurso, "Error al crear el curso", "Atención", JOptionPane.ERROR_MESSAGE);
	    }
	}

	private void cancelarCreacionCurso() {
	    try {
	        panelManager.mostrarPantallaAdministrador();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}

}
