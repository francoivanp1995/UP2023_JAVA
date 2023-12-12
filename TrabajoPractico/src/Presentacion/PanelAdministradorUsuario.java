package Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Servicios.PantallaAdministradorListener;

public class PanelAdministradorUsuario extends JPanel{

//	private JPanel cursoPanel;
//	private JLabel cursoLabel;
//	private JButton cursoCrearBoton;
//	private JButton curoModificarBoton;
//	private JButton cursoEliminarBoton;
//	private JButton cursoReporteBoton;
//	
//	private JPanel profesorPanel;
//	private JLabel profesorLabel;
//	private JButton profesorCrearBoton;
//	private JButton profesorModificarBoton;
//	private JButton profesorEliminarBoton;
//	
	private JPanel alumnoPanel;
	private JLabel alumnoLabel;
	private JButton alumnoCrearBoton;
	private JButton alumnoModificarBoton;
	private JButton alumnoEliminarBoton;
	
	
	private PanelManager panelManager;
	
	public PanelAdministradorUsuario(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		setLayout(new BorderLayout());
    
//	        cursoPanel = new JPanel(new FlowLayout());
//	        cursoLabel = new JLabel("Curso");
//	        cursoCrearBoton = new JButton("Crear");
//	        curoModificarBoton = new JButton("Modificar");
//	        cursoEliminarBoton = new JButton("Eliminar");
//	        cursoReporteBoton = new JButton("Reporte");
//	        cursoPanel.add(cursoLabel);
//	        cursoPanel.add(cursoCrearBoton);
//	        cursoPanel.add(curoModificarBoton);
//	        cursoPanel.add(cursoEliminarBoton);
//	        cursoPanel.add(cursoReporteBoton);
//
//	        profesorPanel = new JPanel(new FlowLayout());
//	        profesorLabel = new JLabel("Profesores");
//	        profesorCrearBoton = new JButton("Crear");
//	        profesorModificarBoton = new JButton("Modificar");
//	        profesorEliminarBoton = new JButton("Eliminar");
//	        profesorPanel.add(profesorLabel);
//	        profesorPanel.add(profesorCrearBoton);
//	        profesorPanel.add(profesorModificarBoton);
//	        profesorPanel.add(profesorEliminarBoton);

	        alumnoPanel = new JPanel(new FlowLayout());
	        alumnoLabel = new JLabel("Alumnos");
	        alumnoCrearBoton = new JButton("Crear");
	        alumnoCrearBoton.addActionListener(new PantallaAdministradorListener(this,panelManager));
	        alumnoModificarBoton = new JButton("Modificar");
	        alumnoModificarBoton.addActionListener(new PantallaAdministradorListener(this, panelManager));
	        alumnoEliminarBoton = new JButton("Eliminar");
	        alumnoEliminarBoton.addActionListener(new PantallaAdministradorListener(this,panelManager));
	        alumnoPanel.add(alumnoLabel);
	        alumnoPanel.add(alumnoCrearBoton);
	        alumnoPanel.add(alumnoModificarBoton);
	        alumnoPanel.add(alumnoEliminarBoton);

//	        add(cursoPanel, BorderLayout.NORTH);
//	        add(profesorPanel, BorderLayout.CENTER);
	        add(alumnoPanel, BorderLayout.CENTER);
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

}