package Presentacion;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Datos.UsuarioAlumno;
import Servicios.PanelCrearAlumnoListener;
import Servicios.PanelEditarCamposAlumnoListener;
import Servicios.PanelModificarAlumnoListener;

public class PanelEditarCamposAlumno extends JPanel{
	
	private PanelManager panelManager;
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel dniLabel;
	private JTextField dniCampo; 
	private JLabel nombreDeUsuarioLabel;
	private JLabel emailLabel;
	private JLabel contraseniaLabel;
	private JTextField nombreCampo;
	private JTextField apellidoCampo;
	private JTextField nombreDeUsuarioCampo;
	private JTextField emailCampo;
	private JPasswordField contraseniaCampo;
	private JButton guardarBoton;
	private JButton cancelarBoton;
	
	
	public PanelEditarCamposAlumno(PanelManager panelManager) {

		this.panelManager = panelManager;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nombreLabel = new JLabel("Nombre");
        nombreCampo = new JTextField();
        JPanel nombrePanel = createLabeledField(nombreLabel, nombreCampo);
        

        apellidoLabel = new JLabel("Apellido");
        apellidoCampo = new JTextField();
        JPanel apellidoPanel = createLabeledField(apellidoLabel, apellidoCampo);

        dniLabel = new JLabel("DNI (requerido)");
        dniCampo = new JTextField();
        JPanel dniPanel = createLabeledField(dniLabel, dniCampo);
        
        nombreDeUsuarioLabel = new JLabel("Nombre de usuario");
        nombreDeUsuarioCampo = new JTextField();
        JPanel usuarioPanel = createLabeledField(nombreDeUsuarioLabel, nombreDeUsuarioCampo);

        emailLabel = new JLabel("Email");
        emailCampo = new JTextField();
        JPanel emailPanel = createLabeledField(emailLabel, emailCampo);

        contraseniaLabel = new JLabel("Contrasenia");
        contraseniaCampo = new JPasswordField();
        JPanel contraseniaPanel = createLabeledField(contraseniaLabel, contraseniaCampo);
        
        guardarBoton = new JButton("GUARDAR");
        guardarBoton.addActionListener(new PanelEditarCamposAlumnoListener(this,panelManager));
        
        cancelarBoton = new JButton("CANCELAR");
        cancelarBoton.addActionListener(new PanelEditarCamposAlumnoListener(this, panelManager));
        
        JPanel botoneraPanel = new JPanel();
        botoneraPanel.setLayout(new FlowLayout());
        botoneraPanel.add(guardarBoton);
        botoneraPanel.add(cancelarBoton);
        
        add(Box.createVerticalStrut(10)); 
        add(nombrePanel);
        add(apellidoPanel);
        add(dniPanel);
        add(usuarioPanel);
        add(emailPanel);
        add(contraseniaPanel);
//        add(tipoPanel);
        add(botoneraPanel);
	}
	
	private JPanel createLabeledField(JLabel label, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(label);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(textField);
        return panel;
	}
	
	public JButton getGuardarBoton() {
		return guardarBoton;
	}
	
	public JButton getCancelarBoton() {
		return cancelarBoton;
	}
	
	public UsuarioAlumno setUsuarioIngresadoEnPanel() {
        UsuarioAlumno usuario = new UsuarioAlumno();
        usuario.setDni(dniCampo.getText());
        usuario.setNombre(nombreCampo.getText());
        usuario.setApellido(apellidoCampo.getText());
        usuario.setNombreDeUsuario(nombreDeUsuarioCampo.getText());
        usuario.setEmail(emailCampo.getText());
        usuario.setContrasenia(contraseniaCampo.getText());
        return usuario;
    }
	
	public void limpiarPanel() {
		dniCampo.setText("");
	    apellidoCampo.setText("");
	}
}
