package Presentacion;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Datos.UsuarioAlumno;
import Servicios.PanelEliminarAlumnoListener;

public class PanelEliminarAlumno extends JPanel{

	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel dniLabel;
	private JButton buscarBoton;
	private JTextField nombreCampo;
	private JTextField apellidoCampo;
	private JTextField dniCampo;
	
	private JButton eliminarBoton;
	private JButton cancelarBoton;
	
	public PanelEliminarAlumno(PanelManager panelManager) {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		nombreLabel = new JLabel("Nombre");
        nombreCampo = new JTextField();
        JPanel nombrePanel = createLabeledField(nombreLabel, nombreCampo);

        apellidoLabel = new JLabel("Apellido requerido");
        apellidoCampo = new JTextField();
        JPanel apellidoPanel = createLabeledField(apellidoLabel, apellidoCampo);

        dniLabel = new JLabel("DNI requerido");
        dniCampo = new JTextField();
        JPanel dniPanel = createLabeledField(dniLabel, dniCampo);
        
        buscarBoton = new JButton("Buscar");
        JPanel botonBuscarPanel = new JPanel();
        botonBuscarPanel.setLayout(new FlowLayout());
        botonBuscarPanel.add(buscarBoton);
        buscarBoton.addActionListener(new PanelEliminarAlumnoListener(this, panelManager));

        eliminarBoton = new JButton("Eliminar");
        eliminarBoton.addActionListener(new PanelEliminarAlumnoListener(this, panelManager));
        
        cancelarBoton = new JButton("Cancelar");
        
        cancelarBoton.addActionListener(new PanelEliminarAlumnoListener(this,panelManager));
        JPanel botoneraPanel = new JPanel();
        botoneraPanel.setLayout(new FlowLayout());
        botoneraPanel.add(eliminarBoton);
        botoneraPanel.add(cancelarBoton);
        
        
        add(Box.createVerticalStrut(10)); 
        add(nombrePanel);
        add(apellidoPanel);
        add(dniPanel);
        add(botonBuscarPanel);
        add(botoneraPanel);
        
	}
	
	public UsuarioAlumno obtenerUsuarioIngresadoEnPanel() {
        UsuarioAlumno usuario = new UsuarioAlumno();
        usuario.setDni(dniCampo.getText());
//        usuario.setNombre(nombreCampo.getText());
        usuario.setApellido(apellidoCampo.getText());
        return usuario;
    }
	
	private JPanel createLabeledField(JLabel label, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(label);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(textField);
        return panel;
	}
	
	public JButton getBuscarBoton() {
		return buscarBoton;
	}
	
	public JButton getEliminarBoton() {
		return eliminarBoton;
	}
	
	public JButton getCancelarBoton() {
		return cancelarBoton;
	}
	
	public void limpiarPanel() {
		dniCampo.setText("");
	    nombreCampo.setText("");
	    apellidoCampo.setText("");
	}
}
