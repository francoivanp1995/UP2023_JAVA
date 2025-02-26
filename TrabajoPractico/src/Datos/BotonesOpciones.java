package Datos;

import javax.swing.JPanel;

import Presentacion.PanelManager;

public abstract class BotonesOpciones extends JPanel{
	
private PanelManager panelManager;
	
	public BotonesOpciones(PanelManager panelManager) {
		this.panelManager = panelManager;
		armarFormulario(); 
	}

	public abstract void armarFormulario();

}
