package Datos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Presentacion.PanelManager;

public abstract class AbstractPantallaUsuarioLogueadoPanel extends JPanel{
	
	protected PanelManager panelManager;
	private BotoneraPanel botonesPanel;
	protected LabelsPanel labelsPanel;
	protected BotonesOpciones botonesOpciones;
	
	public AbstractPantallaUsuarioLogueadoPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
		this.setPantallaUsuario();
		this.setBotoneraPanel();
		armarPantallaPanel();
	}
		
		public void armarPantallaPanel() {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.add(labelsPanel);
			this.add(botonesPanel);
			
			this.botonesPanel.getOkBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ejecutarAccionOk();}
			});
			
			this.botonesPanel.getCancelBtn().addActionListener(new ActionListener() { 
				@Override
			public void actionPerformed(ActionEvent e){
				ejecutarAccionCancel();
			}
			
	});
	
		}
		
	public void setBotoneraPanel() {
		this.botonesPanel= new BotoneraPanel(this.panelManager);
		}
	
	public abstract void setPantallaUsuario();
	public abstract void ejecutarAccionOk();
	public abstract void ejecutarAccionCancel();
	public abstract void setBotonesPanel();
	
}
