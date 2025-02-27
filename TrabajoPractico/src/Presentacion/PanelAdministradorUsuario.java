package Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Datos.BotoneraPanel;
import Servicios.PantallaAdministradorListenerTemaAlumno;
import Servicios.PantallaAdministradorListenerTemaCurso;

public class PanelAdministradorUsuario extends JPanel{

	private JPanel cursoPanel;
	private JLabel cursoLabel;
	private JButton cursoCrearBoton;
	private JButton curoModificarBoton;
	private JButton cursoEliminarBoton;
	private JButton cursoReporteBoton;
	
//	private JPanel profesorPanel;
//	private JLabel profesorLabel;
//	private JButton profesorCrearBoton;
//	private JButton profesorModificarBoton;
//	private JButton profesorEliminarBoton;
	
	private JPanel usuarioPanel;
	private JLabel usuarioLabel;
	private JButton alumnoCrearBoton;
	private JButton alumnoModificarBoton;
	private JButton alumnoEliminarBoton;
	
	
	private PanelManager panelManager;
	
	public PanelAdministradorUsuario(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		setLayout(new GridLayout(4,5));
    
	        cursoPanel = new JPanel(new GridLayout(1,5));
	        
	        cursoLabel = new JLabel("Curso");
	        cursoCrearBoton = new JButton("Crear");
	        cursoCrearBoton.addActionListener(new PantallaAdministradorListenerTemaCurso(this,panelManager));
	        curoModificarBoton = new JButton("Modificar");
	        curoModificarBoton.addActionListener(new PantallaAdministradorListenerTemaCurso(this, panelManager));
	        cursoEliminarBoton = new JButton("Eliminar");
	        cursoEliminarBoton.addActionListener(new PantallaAdministradorListenerTemaCurso(this, panelManager));
	        cursoReporteBoton = new JButton("Reporte");
	        cursoReporteBoton.addActionListener(new PantallaAdministradorListenerTemaCurso(this, panelManager));
	        cursoPanel.add(cursoLabel);
	        cursoPanel.add(cursoCrearBoton);
	        cursoPanel.add(curoModificarBoton);
	        cursoPanel.add(cursoEliminarBoton);
	        cursoPanel.add(cursoReporteBoton);

//	        profesorPanel = new JPanel(new GridLayout(1,4));
//	        profesorLabel = new JLabel("Profesores");
//	        profesorCrearBoton = new JButton("Crear");
//	        profesorModificarBoton = new JButton("Modificar");
//	        profesorEliminarBoton = new JButton("Eliminar");
//	        profesorPanel.add(profesorLabel);
//	        profesorPanel.add(profesorCrearBoton);
//	        profesorPanel.add(profesorModificarBoton);
//	        profesorPanel.add(profesorEliminarBoton);

	        usuarioPanel = new JPanel(new GridLayout(1,4));
	        usuarioLabel = new JLabel("Usuarios");
	        alumnoCrearBoton = new JButton("Crear");
	        alumnoCrearBoton.addActionListener(new PantallaAdministradorListenerTemaAlumno(this,panelManager));
	        alumnoModificarBoton = new JButton("Modificar");
	        alumnoModificarBoton.addActionListener(new PantallaAdministradorListenerTemaAlumno(this, panelManager));
	        alumnoEliminarBoton = new JButton("Eliminar");
	        alumnoEliminarBoton.addActionListener(new PantallaAdministradorListenerTemaAlumno(this,panelManager));
	        usuarioPanel.add(usuarioLabel);
	        usuarioPanel.add(alumnoCrearBoton);
	        usuarioPanel.add(alumnoModificarBoton);
	        usuarioPanel.add(alumnoEliminarBoton);

	        add(cursoPanel);
//	        add(profesorPanel);
	        add(usuarioPanel);
	        
//	        add(cursoPanel, BorderLayout.NORTH);
//	        add(profesorPanel, BorderLayout.CENTER);
//	        add(alumnoPanel, BorderLayout.SOUTH);
	}

	public JButton getAlumnoCrearBoton() {
	    return alumnoCrearBoton;
	}
	
	public JButton getAlumnoModificarBoton() {
		return alumnoModificarBoton;
	}

	public JButton getAlumnoEliminarBoton() {
	    return alumnoEliminarBoton;
	}
	
	public JButton getcursoCrearBoton() {
		return cursoCrearBoton;
	}

	public JButton getCursoModificarBoton() {
		return curoModificarBoton;
	}
	
	public JButton getCursoEliminarBoton() {
		return cursoEliminarBoton;
	}
	
	public JButton getCursoReporteBoton() {
		return cursoReporteBoton;
	}
}