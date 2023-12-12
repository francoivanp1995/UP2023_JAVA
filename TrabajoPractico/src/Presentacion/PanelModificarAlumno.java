package Presentacion;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Datos.UsuarioAlumno;
import Servicios.PanelModificarAlumnoListener;

public class PanelModificarAlumno extends JPanel{

	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel dniLabel;
	private JTextField nombreCampo;
	private JTextField apellidoCampo;
	private JTextField dniCampo;
	private JButton consultarBoton;
	private JButton editarBoton;
	private JButton cancelarBoton;
	
	
	public PanelModificarAlumno(PanelManager panelManager) {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
        dniLabel = new JLabel("DNI requerido");
        dniCampo = new JTextField();
        JPanel dniPanel = createLabeledField(dniLabel, dniCampo);
		
//		nombreLabel = new JLabel("Nombre");
//        nombreCampo = new JTextField();
//        JPanel nombrePanel = createLabeledField(nombreLabel, nombreCampo);

        apellidoLabel = new JLabel("Apellido requerido");
        apellidoCampo = new JTextField();
        JPanel apellidoPanel = createLabeledField(apellidoLabel, apellidoCampo);

        consultarBoton = new JButton("CONSULTAR");
        consultarBoton.addActionListener(new PanelModificarAlumnoListener(this, panelManager));
        JPanel consultarPanel = new JPanel();
        consultarPanel.add(consultarBoton);
        
//        editarBoton = new JButton("EDITAR");
//        editarBoton.setEnabled(false);
//        editarBoton.addActionListener(new PanelModificarAlumnoListener(this, panelManager));
        cancelarBoton = new JButton("CANCELAR");
        cancelarBoton.addActionListener(new PanelModificarAlumnoListener(this, panelManager));
        JPanel botoneraPanel = new JPanel();
        botoneraPanel.setLayout(new FlowLayout());
//        botoneraPanel.add(editarBoton);
        botoneraPanel.add(cancelarBoton);
        
        
        add(Box.createVerticalStrut(10));
        add(dniPanel);
//        add(nombrePanel);
        add(apellidoPanel);
        add(consultarPanel);
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
	
	public JButton getEditarBoton() {
		return editarBoton;
	}
	
	public JButton getCancelarBoton() {
		return cancelarBoton;
	}
	
	public JButton getConsultarBoton() {
		return consultarBoton;
	}
	
	public void limpiarPanel() {
		dniCampo.setText("");
	    apellidoCampo.setText("");
	}
	
}
