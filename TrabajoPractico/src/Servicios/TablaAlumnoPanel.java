package Servicios;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import Datos.AlumnoTableModel;

public class TablaAlumnoPanel extends JPanel {

	private JTable tablaAlumno;
	private AlumnoTableModel modelo;
	private String nombre;
	private String apellido;
	private String dni;
	
	public TablaAlumnoPanel() {
		super();
		armarPanel();
	}
	
	private void armarPanel() {
		this.setLayout(new FlowLayout());
		
		modelo = new AlumnoTableModel();
		tablaAlumno = new JTable(modelo);
	}
	
	public void actualizarTabla(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
}
