package Datos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentacion.PanelManager;

public class PanelProfesorUsuario extends JPanel {

	protected PanelManager panelManager;
	protected BotonesOpcionesAlumnoProfesor botonesOpcionesAlumnoProfesor;
	protected BotonesOpcionesCursoProfesor botonesOpcionesCursoProfesor;
	protected BotoneraPanel botoneraPanel;
	
	public PanelProfesorUsuario(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		this.setLayout(new GridLayout(4,4));
		
		JLabel cursoLabel = new JLabel("Cursos");
		botonesOpcionesCursoProfesor = new BotonesOpcionesCursoProfesor(panelManager);
		JLabel alumnoLabel = new JLabel("Alumnos");
		botonesOpcionesAlumnoProfesor = new BotonesOpcionesAlumnoProfesor(panelManager);
		
//		No necesito la botonera todavia
//		botoneraPanel = new BotoneraPanel(this.panelManager);
		
		this.add(cursoLabel);
		this.add(botonesOpcionesCursoProfesor);
		this.add(alumnoLabel);
		this.add(botonesOpcionesAlumnoProfesor);
//		this.add(botoneraPanel);
	}
	
}
