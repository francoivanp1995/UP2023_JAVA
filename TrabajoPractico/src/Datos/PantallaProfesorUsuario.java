package Datos;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

import Presentacion.PanelManager;

//ToDo: renombrar a panel principal del Usuario Profesor.

public class PantallaProfesorUsuario extends AbstractPantallaUsuarioLogueadoPanel{
	
	BotonesOpcionesAlumnoProfesor botonesOpcionesAlumnoProfesor;
	BotonesOpcionesCursoProfesor botonesOpcionesCursoProfesor;
	protected PanelManager panelManager;

	public PantallaProfesorUsuario(PanelManager panelManager) {
		super(panelManager);
	}

//	@Override
//	public void armarFormulario() {
//		this.setLayout(new GridLayout(4,4));
//		
//		JLabel cursoLabel = new JLabel("Cursos");
//		botonesOpcionesCursoProfesor = new BotonesOpcionesCursoProfesor(panelManager);
//		JLabel alumnoLabel = new JLabel("Alumnos");
//		botonesOpcionesAlumnoProfesor = new BotonesOpcionesAlumnoProfesor(panelManager);
//		
//		this.add(cursoLabel);
//		this.add(botonesOpcionesCursoProfesor);
//		this.add(alumnoLabel);
//		this.add(botonesOpcionesAlumnoProfesor);
//	}

	@Override
	public void setPantallaUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejecutarAccionOk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejecutarAccionCancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBotonesPanel() {
		// TODO Auto-generated method stub
		
	}
	
}
