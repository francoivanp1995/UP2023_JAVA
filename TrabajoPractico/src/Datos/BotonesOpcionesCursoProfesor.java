package Datos;

import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import Presentacion.PanelManager;

public class BotonesOpcionesCursoProfesor extends BotonesOpciones{

	protected JButton calendarioBoton;
	protected JButton evaluacionesBoton;
	protected JButton encuestasBoton;
	protected JButton contenidoBoton;
	
	
	public BotonesOpcionesCursoProfesor(PanelManager panelManager) {
		super(panelManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void armarFormulario() {
		
		this.setLayout(new GridLayout(1,4));
		
		calendarioBoton = new JButton("Calendario");
		evaluacionesBoton = new JButton("Evaluaciones");
		encuestasBoton = new JButton("Encuestas");
		contenidoBoton = new JButton("Contenido");
		
		this.add(calendarioBoton);
		this.add(evaluacionesBoton);
		this.add(encuestasBoton);
		this.add(contenidoBoton);
	}
	
	public AbstractButton getCalendarioBoton() {
		return calendarioBoton;
	}
	
	public AbstractButton getEvaluacionesBoton() {
		return evaluacionesBoton;
	}
	
	public AbstractButton getEncuestasBotonn() {
		return encuestasBoton;
	}
	
	public AbstractButton getContenidoBoton() {
		return contenidoBoton;
	}

}
