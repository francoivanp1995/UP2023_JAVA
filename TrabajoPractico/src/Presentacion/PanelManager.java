package Presentacion;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Servicios.PanelEditarCamposAlumnoListener;
import Servicios.ServicioAutenticacion;

public class PanelManager {
	
	private JFrame frame;
	private PanelInicioSesion pantallaInicioSesion;
	private PanelAdministradorUsuario pantallaAdministrador;
	private PanelCrearAlumno panelCrearAlumno;
	private PanelEliminarAlumno panelEliminarAlumno;
	private PanelModificarAlumno panelModificarAlumno;
	private PanelEditarCamposAlumno panelEditarCamposAlumno;
	
	public void armarManager() {
		frame = new JFrame("SISTEMA DE ALUMNOS");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantallaInicioSesion = new PanelInicioSesion(this);
		pantallaAdministrador = new PanelAdministradorUsuario(this);
		panelCrearAlumno = new PanelCrearAlumno(this);
		panelEliminarAlumno = new PanelEliminarAlumno(this);
		panelModificarAlumno = new PanelModificarAlumno(this);
		panelEditarCamposAlumno = new PanelEditarCamposAlumno(this);
		frame.add(pantallaInicioSesion);
		frame.add(pantallaAdministrador);
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
	
}
