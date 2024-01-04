package Presentacion;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Datos.PanelProfesorUsuario;
import Servicios.PanelEditarCamposAlumnoListener;
import Servicios.ServicioAutenticacion;

public class PanelManager {
	
	private JFrame frame;
	private PanelInicioSesion pantallaInicioSesion;
	private PanelAdministradorUsuario pantallaAdministrador;
	private PanelProfesorUsuario pantallaProfesor;
	private PanelAlumnoUsuario pantallaAlumno;
	private PanelCrearAlumno panelCrearAlumno;
	private PanelEliminarAlumno panelEliminarAlumno;
	private PanelModificarAlumno panelModificarAlumno;
	private PanelEditarCamposAlumno panelEditarCamposAlumno;
	
	//todo
	private PanelCrearCurso panelCrearCurso;
	private PanelModificarCurso panelModificarCurso;
	private PanelEliminarCurso panelEliminarCurso;
	private PanelReporteCurso panelReporteCurso;
	
	
	public void armarManager() {
		frame = new JFrame("SISTEMA DE ALUMNOS");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pantallaInicioSesion = new PanelInicioSesion(this);
		pantallaAdministrador = new PanelAdministradorUsuario(this);
		pantallaProfesor = new PanelProfesorUsuario(this);
		pantallaAlumno = new PanelAlumnoUsuario(this);
		panelCrearAlumno = new PanelCrearAlumno(this);
		panelEliminarAlumno = new PanelEliminarAlumno(this);
		panelModificarAlumno = new PanelModificarAlumno(this);
		panelEditarCamposAlumno = new PanelEditarCamposAlumno(this);
		
		panelCrearCurso = new PanelCrearCurso(this);
		panelModificarCurso = new PanelModificarCurso(this);
		panelEliminarCurso = new PanelEliminarCurso(this);
		panelReporteCurso = new PanelReporteCurso(this);
		
		
		frame.add(pantallaInicioSesion);
		frame.add(pantallaAdministrador);
		frame.add(pantallaProfesor);
		frame.add(pantallaAlumno);
		frame.add(panelCrearAlumno);
		frame.add(panelEliminarAlumno);
		frame.add(panelModificarAlumno);
	}
	
	public void showFrame() {
		frame.setVisible(true);
	}
	
	public void mostrarInicioPanel() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaInicioSesion);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaAdministrador() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaAdministrador);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaProfesor() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaProfesor);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaAlumno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaAlumno);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaCrearAlumno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelCrearAlumno);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaModificarAlumno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelModificarAlumno);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaEliminarAlumno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelEliminarAlumno);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaEditarCamposAlumno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelEditarCamposAlumno);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaCrearCurso() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelCrearCurso);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostarPantallaModificarCurso() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelModificarCurso);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaEliminarCurso() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelEliminarCurso);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPantallaReporteCurso() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelReporteCurso);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
}
