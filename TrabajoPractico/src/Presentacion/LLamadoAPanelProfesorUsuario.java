package Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Datos.AbstractPantallaUsuarioLogueadoPanel;
import Datos.BotoneraPanel;
import Datos.BotonesOpcionesAlumnoProfesor;
import Datos.PantallaProfesorUsuario;

public class LLamadoAPanelProfesorUsuario extends AbstractPantallaUsuarioLogueadoPanel{
	
	protected JPanel cursoPanel;
	protected JLabel cursoLabel;
	protected PanelManager panelManager;
	protected BotoneraPanel botoneraPanel;
	
	public LLamadoAPanelProfesorUsuario(PanelManager panelManager) {
		super(panelManager);
		this.armarPantallaPanel();
	}

	@Override
	public void setPantallaUsuario() {
//		this.labelsPanel = new PantallaProfesorUsuario(panelManager);
		
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
		this.botoneraPanel = new BotoneraPanel(panelManager);
	}
}
