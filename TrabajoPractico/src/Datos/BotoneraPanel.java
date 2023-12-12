package Datos;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import Presentacion.PanelManager;

public class BotoneraPanel extends JPanel{
	
	private PanelManager panelManager;
	private JButton okBoton;
	private JButton cancelarBoton;
	
	public BotoneraPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
		armarBotoneraPanel();
	}
	
	public void armarBotoneraPanel() {
		this.setLayout(new FlowLayout());
		okBoton = new JButton("ACEPTAR");
		cancelarBoton = new JButton("CANCELAR");
		
		this.add(okBoton);
		this.add(cancelarBoton);
	}
}
