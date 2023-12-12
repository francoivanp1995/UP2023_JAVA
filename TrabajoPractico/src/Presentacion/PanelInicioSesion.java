package Presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Servicios.PanelInicioSesionListener;

public class PanelInicioSesion extends JPanel{
	
	private JPanel tituloPanel;
	private JLabel nombreTitulo;
	
	private JPanel formularioCamposPanel;
	private JPanel camposPanel;
	private JLabel loginLabel;
	private JTextField loginCampo;
	private JLabel passwordLabel;
	private JPasswordField passwordCampo;
	
	private JPanel mensajeValidacionPanel;
	private JLabel mensajeValidacionLabel;
	
	private JPanel botoneraPanel;
	private JButton aceptarBoton;
	private JButton cancelarBoton;
	
	private PanelManager panelManager;
	
	
	public PanelInicioSesion(PanelManager panelManager) {
		this.panelManager = panelManager;
		setLayout(new BorderLayout());
		
		tituloPanel = new JPanel();
		nombreTitulo = new JLabel("SISTEMA DE ALUMNOS");
		tituloPanel.add(nombreTitulo);
		add(tituloPanel, BorderLayout.NORTH);
		
		formularioCamposPanel = new JPanel();
		camposPanel = new JPanel(new GridLayout(2, 2));
		loginLabel = new JLabel("Login");
		loginCampo = new JTextField();
		passwordLabel = new JLabel("Password");
		passwordCampo = new JPasswordField();
		camposPanel.add(loginLabel);
        camposPanel.add(loginCampo);
        camposPanel.add(passwordLabel);
        camposPanel.add(passwordCampo);
        formularioCamposPanel.add(camposPanel);
        add(formularioCamposPanel, BorderLayout.CENTER);
		
		botoneraPanel = new JPanel();
		aceptarBoton = new JButton("ACEPTAR");
		aceptarBoton.addActionListener(new PanelInicioSesionListener(this,panelManager));
		cancelarBoton = new JButton("CANCELAR");
		cancelarBoton.addActionListener(new PanelInicioSesionListener(this,panelManager));
		botoneraPanel.add(aceptarBoton);
        botoneraPanel.add(cancelarBoton);
        add(botoneraPanel, BorderLayout.SOUTH);
        
        mensajeValidacionPanel = new JPanel();
        mensajeValidacionLabel = new JLabel();
        mensajeValidacionPanel.add(mensajeValidacionLabel);
        add(mensajeValidacionPanel, BorderLayout.EAST);
		
	}
	
	public JButton getAceptarBoton() {
	    return aceptarBoton;
	}
	
	public JButton getCancelarBoton() {
		return cancelarBoton;
	}

	public JTextField getLoginCampo() {
	    return loginCampo;
	}

	public JPasswordField getPasswordCampo() {
	    return passwordCampo;
	}
	
	public void setMensajeValidacion(String mensaje) {
        mensajeValidacionLabel.setText(mensaje);
    }
	
	public void limpiarPanel() {
		loginCampo.setText("");
		passwordCampo.setText("");
	}
}
