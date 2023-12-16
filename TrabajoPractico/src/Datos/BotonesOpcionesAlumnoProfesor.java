package Datos;

import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;

import Presentacion.PanelManager;

public class BotonesOpcionesAlumnoProfesor extends BotonesOpciones{
	
	protected JButton asistenciaBoton;
	protected JButton calificacionesBoton;
	protected JButton seguimientoProgresoBoton;
	protected JButton comunicacionBoton;

	public BotonesOpcionesAlumnoProfesor(PanelManager panelManager) {
		super(panelManager);
	}

	@Override
	public void armarFormulario() {
		
		this.setLayout(new GridLayout(1,4));
		
		asistenciaBoton = new JButton("Asistencia");
		calificacionesBoton = new JButton("Calificaciones");
		seguimientoProgresoBoton = new JButton("Seguimiento");
		comunicacionBoton = new JButton("Comunicacion");
		
		this.add(asistenciaBoton);
		this.add(calificacionesBoton);
		this.add(seguimientoProgresoBoton);
		this.add(comunicacionBoton);
		
	}
	
	public AbstractButton getAsistenciaBoton() {
		return asistenciaBoton;
	}
	
	public AbstractButton getCalificacionesBoton() {
		return calificacionesBoton;
	}
	
	public AbstractButton getSeguimientoProgresoBoton() {
		return seguimientoProgresoBoton;
	}
	
	public AbstractButton getComunicacionBoton() {
		return comunicacionBoton;
	}

}
