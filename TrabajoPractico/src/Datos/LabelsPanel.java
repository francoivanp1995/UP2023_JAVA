package Datos;

import javax.swing.JPanel;

import Presentacion.PanelManager;

public abstract class LabelsPanel extends JPanel{
	
	private PanelManager panelManager;
	
	public LabelsPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
		armarFormulario(); 
	}

	public abstract void armarFormulario();
}
